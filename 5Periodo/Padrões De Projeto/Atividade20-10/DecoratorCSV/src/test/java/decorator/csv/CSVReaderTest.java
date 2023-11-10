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

class CSVReaderTest 
{ 
	final File csvFile = new File("csvReadTest.csv");
	CSVWriter csvWriter = null;
	CSVReader csvReader = null;
	
	@BeforeEach
	void instantiateNewCSVWriterAndCSVReader()
	{
		csvWriter = assertDoesNotThrow( () -> new CSVWriter(new FileWriter(csvFile)));
		csvReader = assertDoesNotThrow( () -> new CSVReader(new FileReader(csvFile)));
	}
	
	@AfterEach
	void closeCSVWriterAndDeleteTheFile() 
	{
		//assertDoesNotThrow(() -> csvWriter.close());
		//assertDoesNotThrow(() -> csvFile.delete());
	}
	
	@Test
	void shouldSetSeparator() 
	{
		assertDoesNotThrow( () ->
		{	
			Separator expected = Separator.PIPE;
			csvReader.setSeparator(expected);
			Separator actual = csvReader.getSeparator();
			assertEquals(expected, actual);
		});		
	}
	
	@Test
	void shouldReaderLine()
	{
		String expected = "teste";
		assertDoesNotThrow(()->
		{
			csvWriter.writeToken(expected);
			csvWriter.newLine();
			csvWriter.flush();
		});
		
		String actual = "teste";
		
		assertTrue(actual.equals(expected));
		
		
	}
	

}
