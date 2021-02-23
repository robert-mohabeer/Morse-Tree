public class MorseTreeNode{
	public char letter;
	public MorseTreeNode right;
	public MorseTreeNode left;
	
	public MorseTreeNode(char letter) {//default constructor if no subtrees given (mostly for 6th level nodes)
		
			this(letter, null, null);
		}
	
	public MorseTreeNode(char letter, MorseTreeNode left, MorseTreeNode right) {
		this.letter = letter;
		this.left = left;
		this.right = right;
	}
	
	public void findLetterPath(MorseTreeNode begin, String code, int index)//executes private methods below
	{
		System.out.println("\nCorresponding letter or number: " + findLetter(findLetterPath2(begin, code, index)));//prints out the final translation
	}
	
	private MorseTreeNode findLetterPath2(MorseTreeNode begin, String code, int index)
	{
		if(index < code.length())//will continue for as long as there are characters to use in the code to traverse the tree (one character per recursion)
		{
			if(code.charAt(index) == '.')//if the character is a dot, will go down towards the right
			{
				return findLetterPath2(begin.right, code, index+1);//index up by one so it will check the next character in the code
			}
			else//if it is a dash, will go down towards the left
				{
					return findLetterPath2(begin.left, code, index+1);
				}
		}
		else//if the index reaches the end, it will simply return whatever node findLetterPath2 is currently using (as that is the one we are looking for)
		{
			return begin;
		}
	}
	
	private char findLetter(MorseTreeNode nodeWithLetter)//uses the MorseTreeNode from findLetterPath2 for printing the translated morse code
	{
		return nodeWithLetter.letter;//returns whatever the char is at that node to the findLetterPath method
	}
}
