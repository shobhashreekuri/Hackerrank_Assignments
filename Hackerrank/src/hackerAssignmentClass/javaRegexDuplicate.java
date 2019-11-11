/*
### Regex
I used this regular expression: "\b(\w+)(?:\W+\1\b)+"
When using this regular expression in Java, we have to "escape" the backslash characters with additional backslashes (as done in the code above).
\w ----> A word character: [a-zA-Z_0-9] <br/>
\W ----> A non-word character: [^\w]<br/>
\b ----> A word boundary  <br/>
\1 ----> Matches whatever was matched in the 1st group of parentheses, which in this case is the (\w+)  <br/>
+ ----> Match whatever it's placed after 1 or more times
The \b boundaries are needed for special cases such as "Bob and Andy" (we don't want to match "and" twice). Another special case is "My thesis is great" (we don't want to match "is" twice).
### Groups
input = input.replaceAll(m.group(), m.group(1))
The line of code above replaces the entire match with the first group in the match.
m.group() is the entire match <br/>
m.group(i) is the ith match. So m.group(1) is the 1st match (which is enclosed in the 1st set of parentheses)
The ?: is added to make it a "non-capturing group", for slightly faster performance.
10/20/18 - Looks like the problem statement changed a bit, and digits should no longer be in the regular expression. User @4godspeed has an updated solution: https://www.hackerrank.com/challenges/duplicate-word/forum/comments/503715 that may work.
*/
//
package hackerAssignmentClass;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class javaRegexDuplicate {

	public static void main(String[] args) {
	
		String RegularExpression = "\\b(\\w+)(?:\\W+\\1\\b)+";
		Pattern p = Pattern.compile(RegularExpression, Pattern.CASE_INSENSITIVE);
		
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		
		while(n-- > 0) 
		{
			String in = scan.nextLine();
			Matcher m = p.matcher(in);
			
			// Check for subsequences of input that match the compiled pattern
			while(m.find()) 
			{
				in = in.replaceAll(m.group(), m.group(1));
			}
			System.out.println(in);
		}
		scan.close();
	
	}

}
