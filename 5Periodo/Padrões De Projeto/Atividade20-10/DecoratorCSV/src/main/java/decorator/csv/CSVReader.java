package decorator.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CSVReader extends Reader 
{
    private BufferedReader buffReader = null;
    private Separator separator = Separator.COMMA;

    public CSVReader(Reader in) 
    {
        super(in);

        if (!(in instanceof BufferedReader)) 
            in = new BufferedReader(in);

        buffReader = (BufferedReader) in;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return this.buffReader.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        this.buffReader.close();
    }

    public Separator getSeparator() {
        return separator;
    }

    public void setSeparator(Separator newSeparator) {
        separator = newSeparator;
    }

    public String[] readNextLine() throws IOException {
        String line = buffReader.readLine();
        if (line == null) {
            return null;
        }

        return line.split(separator.asString());
    }
}
