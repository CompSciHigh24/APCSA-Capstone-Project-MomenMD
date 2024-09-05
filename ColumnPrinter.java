
//https://www.w3schools.com/java/java_arraylist.asp
import java.util.ArrayList;

/**
ColumnPrinter printer = new ColumnPrinter();
printer.add(new String[]{
	" _____ ",
	"|     |",
	"|k    |",
	"|    ʞ|",
	"|_____|",
});
printer.add(new String[]{
	" _____ ",
	"|     |",
	"|q    |",
	"|    b|",
	"|_____|",
});
printer.render();
**/

/*
	The class prints multi-line strings in a single row.
 	This is in order to print cards in a row.
*/
public class ColumnPrinter {
	private ArrayList<String> lines;

	/*
		index 0 is line 1
		index 1 is line 2
		...
	*/
	public ColumnPrinter() {
		this.lines = new ArrayList<String>();
	}

	public void add(String[] lines){
		// concatnates all the strings in the array
		for (int i = 0; i < lines.length; i++) {
			if (i >= this.lines.size()) {
				this.lines.add("");
			}

			String newLine = this.lines.get(i) + lines[i];
			this.lines.set(i, newLine);
		}
	}

	// prints out all the concatnates strings to form a multi-line row printer.
	public void render() {
		for (String line: this.lines) {
			System.out.println(line);
		}
	}
}