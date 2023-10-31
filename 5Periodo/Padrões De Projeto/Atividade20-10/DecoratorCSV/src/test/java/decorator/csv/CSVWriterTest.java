package decorator.csv;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class CSVWriterTest 
{
	
	@TempDir
	static File tempDirPath; 
	
	final File csvFile = new File(tempDirPath, "csvTest.csv");
	CSVWriter csvWriter = null;
	
	@BeforeAll
	static void shouldExisteTemporaryDirectory()
	{
		assertTrue(tempDirPath.isDirectory(), "Should be a directory ");
	}
	
	@BeforeEach
	void instantiateNewCSVWriter()
	{
		csvWriter = assertDoesNotThrow( () -> new CSVWriter(new FileWriter(csvFile)));
	}
	
	@AfterEach
	void closeCSVWriterAndDeleteTheFile() 
	{
		assertDoesNotThrow(() -> csvWriter.close());
		assertDoesNotThrow(() -> csvFile.delete());
	}
	
	private char[] readFileContent(File file)
	{
		return assertDoesNotThrow(() -> 
		{
			char[] buffer = new char[(int) file.length()];
			FileReader fileReader = new FileReader(csvFile);
			fileReader.read(buffer);
			fileReader.close();
			return buffer;
		});
	}

	@Test
	void shouldSetSeparator() 
	{
		assertDoesNotThrow( () ->
		{	
			Separator expected = Separator.PIPE;
			csvWriter.setSeparator(expected);
			Separator actual = csvWriter.getSeparator();
			assertEquals(expected, actual);
		});
	}
	
	@Test
	void shouldWriteSeparator()
	{
		csvWriter.setSeparator(Separator.PIPE);
		char expected = Separator.PIPE.asChar();
		
		assertDoesNotThrow( () ->
		{			
			csvWriter.writeSeparator();
			csvWriter.flush();
		});
		
		char[] actual = readFileContent(csvFile);
		assertTrue(actual.length==1);
		assertEquals(expected, actual[0]);
	}
	
	@Test
	void shouldWriteAnUniqueToken()
	{
		String token = "Ameixa";
		assertDoesNotThrow(() -> 
		{
			csvWriter.writeToken(token);
			csvWriter.flush();
		});
		
		char[] fileContent = readFileContent(csvFile);
		String actual = new String(fileContent);
		
		assertTrue(actual.equals(token));
	}
	
	@Test
	void shouldWriteTokenAndSeparator()
	{
		String token = "Ameixa";
		assertDoesNotThrow( () ->
		{	
			csvWriter.writeToken(token);
			csvWriter.writeSeparator();
			csvWriter.flush();
		});
		
		String expected = token + csvWriter.getSeparator().asChar();
		
		char[] fileContent = readFileContent(csvFile);
		String actual = new String(fileContent);
		
		assertTrue(actual.equals(expected));			
	}
	
	@Test
	void shouldWriteAnArrayOfTokensWithSeparatorBetweenThan()
	{
		String expected = "Ameixa;Banana;Maçã;Batata Doce;Pera;Uva";
		String[] tokens = expected.split(";");
	
		assertDoesNotThrow(()->
		{
			csvWriter.setSeparator(Separator.SEMICOLON);
			csvWriter.writeTokens(tokens);
			csvWriter.flush();
		});
		
		String actual = new String(readFileContent(csvFile));
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	void shouldWriteALineOfTokens()
	{
		String expected = "Ameixa|Banana|Maçã|Laranja Lima|Pera|Uva\r\n"+
	                      "Pêssego |Maracujá|Fruta do Conde|Graviola\r\n"+
						  "Acerola|Limão Rosa|Manga\r\n";
		
		csvWriter.setSeparator(Separator.PIPE);
		assertDoesNotThrow(()->
		{
			String[] lines = expected.split("\r\n");
			for(String line : lines)
			{
				String[] tokens = line.split("\\|");
				csvWriter.writeLine(tokens);
			}
			csvWriter.flush();
		});
		
		String actual = new String(readFileContent(csvFile));
		
		assertTrue(expected.equals(actual));
		}	
}
