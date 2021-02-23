import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ClientForMorseTree {

	public static void main(String[] args) throws FileNotFoundException{
		
		String testcode = "";//will hold the string of dots and dashes for morse code
		Scanner input = new Scanner(new File("encodings.txt"));//reads from the file containing all morse code combinations
		
		Random ran = new Random();//the random variable is simply the way I read any particular morse code sequence, it will pic a random sequence from the list
		int random = ran.nextInt(34)+1;
		
		for (int x = 0; x < random; x++)//whatever random is, it will be the sequence selected from the list
		{
			testcode = input.nextLine();//will make testcode the next line in the file
		}
		
		//testcode = ""; <--you can uncomment this if you want to make testcode any sequence you wish. Essentially cancelling out the random sequence before
		System.out.println("Morse Code to be translated: " + testcode);
		
		//This section is dedicated to constructing the actual tree, with the char values corresponding binary tree which I have cited in my submission from: http://www.learnmorsecode.com/
		//They use the default constructor in the MorseTreeNode.java file to create individual nodes
		//The root node is left blank and referred to as 'start'
		//Nodes titled 'blank' refer to nodes on the chart that hold no real value, but are stepping stones to further nodes. Doesn't matter what char value they contain for the project
		
		//6th level subtrees
		MorseTreeNode zero = new MorseTreeNode('0');
		MorseTreeNode nine = new MorseTreeNode('9');
		MorseTreeNode eight = new MorseTreeNode('8');
		MorseTreeNode seven = new MorseTreeNode('7');
		MorseTreeNode six = new MorseTreeNode('6');
		
		MorseTreeNode one = new MorseTreeNode('1');
		MorseTreeNode two = new MorseTreeNode('2');
		MorseTreeNode three = new MorseTreeNode('3');
		MorseTreeNode four = new MorseTreeNode('4');
		MorseTreeNode five = new MorseTreeNode('5');
		
		//5th level subtrees
		MorseTreeNode blank = new MorseTreeNode('-', zero, nine); //subtrees: nine and zero
		MorseTreeNode blank2 = new MorseTreeNode('.', null, eight); //subtree: eight
		MorseTreeNode q = new MorseTreeNode('Q');
		MorseTreeNode z = new MorseTreeNode('Z', null, seven); //subtree: seven
		MorseTreeNode y = new MorseTreeNode('Y');
		MorseTreeNode c = new MorseTreeNode('C');
		MorseTreeNode x = new MorseTreeNode('X');
		MorseTreeNode b = new MorseTreeNode('B', null, six); //subtree: six
		MorseTreeNode j = new MorseTreeNode('J', one, null); //subtree: one
		MorseTreeNode p = new MorseTreeNode('P');
		MorseTreeNode l = new MorseTreeNode('L');
		MorseTreeNode blank3 = new MorseTreeNode('_', two, null); //subtree: two
		MorseTreeNode f = new MorseTreeNode('F');
		MorseTreeNode v = new MorseTreeNode('V', three, null); //subtree: three
		MorseTreeNode h = new MorseTreeNode('H', four, five); //subtrees: four and five
		
		//4th level subtrees
		MorseTreeNode o = new MorseTreeNode('O', blank, blank2);//subtrees: blank and blank2
		MorseTreeNode g = new MorseTreeNode('G', q, z);//subtrees: q and z
		MorseTreeNode k = new MorseTreeNode('K', y, c);//subtrees: y and c
		MorseTreeNode d = new MorseTreeNode('D', x, b);//subtrees: x and b
		MorseTreeNode w = new MorseTreeNode('W', j, p);//subtrees: j and p
		MorseTreeNode r = new MorseTreeNode('R', blank, l);//subtrees: blank and l
		MorseTreeNode u = new MorseTreeNode('U', blank3, f);//subtrees: blank3 and f
		MorseTreeNode s = new MorseTreeNode('S', v, h);//subtrees: v and h
		
		//3rd level subtrees
		MorseTreeNode m = new MorseTreeNode('M', o, g);
		MorseTreeNode n = new MorseTreeNode('N', k, d);
		MorseTreeNode a = new MorseTreeNode('A', w, r);
		MorseTreeNode i = new MorseTreeNode('I', u, s);
		
		//2nd level subtrees
		MorseTreeNode t = new MorseTreeNode('T', m, n);//left half of the tree
		MorseTreeNode e = new MorseTreeNode('E', a, i);//right half of the tree
		
		//Overall Root of the tree (Level 1)
		MorseTreeNode start = new MorseTreeNode(' ', t, e);
		
		//Calls the method in the MorseTreeNode.java file, which will print out the character as well, uses index as 0 for the purpose of recursion in the method
		start.findLetterPath(start, testcode, 0);
	}

}

