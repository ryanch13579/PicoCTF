// These pesky special agents keep reverse engineering our source code and then
// breaking into our secret vaults. THIS will teach those sneaky sneaks a
// lesson.
//
// -Minion #0891
import java.util.*; 
import javax.crypto.Cipher; 
import javax.crypto.spec.SecretKeySpec;
import java.security.*; 

class VaultDoor8 
{
    public static void main(String args[]) 
{
    Scanner b = new Scanner(System.in); 
    System.out.print("Enter vault password: ");
    String c = b.next(); 
    String f = c.substring(8,c.length()-1); 
    VaultDoor8 a = new VaultDoor8(); 
    
    // Checks password

    if (a.checkPassword(f)) 
    {
        // Password Success
        System.out.println("Access granted."); 
    }
    
    else 
    {
        // Password Failure
        System.out.println("Access denied!"); 
    } 
        
} 
        public char[] scramble(String password)

        {/* Scramble a password by transposing pairs of bits. */
        
        char[] a = password.toCharArray(); // Converts pwd [String -> Char array]
        
        for (int b=0; b<a.length; b++) // Loop thru each char
        {
            //LSB{char} => [0,1,2,3,4,5,6,7]

            char c = a[b];     // Retrieve the charater at index b -> First 8 bits is swapped / 16 bits [Char]  
            c = switchBits(c,1,2); // Swap 2nd and 3rd bit in char -> [0,2,1,3,4,5,6,7]
            c = switchBits(c,0,3); // Swap 1st and 4th bit in char -> []
            c = switchBits(c,5,6); // Swap 6th and 7th bit in char
            c = switchBits(c,4,7); // Swap 5th and 8th bit in char
            c = switchBits(c,0,1); // Swap 1st and 2nd bit in char
            c = switchBits(c,3,4); // Swap 4th and 5th bit in char
            c = switchBits(c,2,5); // Swap 3rd and 6th bit in char
            c = switchBits(c,6,7); // Swap 7th and 8th bit in char
            a[b] = c; // Modified char stored back in the char at index b
            
        } 
            
            return a;

        } 

public char switchBits(char c, int p1, int p2) 
{
char mask1 = (char)(1 << p1); // Create bitmask with 1 at position p1
char mask2 = (char)(1 << p2); // Create bitmask with 1 at position p2

char bit1 = (char)(c & mask1); // Isolate bit at position p1. All other bits become 0
char bit2 = (char)(c & mask2); // Isolate bit at position p2. All other bits become 0

char rest = (char)(c & ~(mask1 | mask2)); // Clears bits at position p1 + p2 in c
char shift = (char)(p2 - p1);  // Calc how far apart 2 positions are
char result = (char)((bit1<<shift) | (bit2>>shift) | rest); // Move bit1 from p1 to p2 [Vice Versa]
return result; // Return characters with swapped bits
}

public boolean checkPassword(String password) 
{
    char[] scrambled = scramble(password); 
    char[] expected = 
    {
        0xF4, 0xC0, 0x97, 0xF0, 0x77, 0x97, 0xC0, 0xE4, 0xF0, 0x77, 0xA4, 0xD0, 0xC5, 0x77, 0xF4, 0x86, 0xD0, 0xA5, 0x45, 0x96, 0x27, 0xB5, 0x77, 0xC2, 0xD2, 0x95, 0xA4, 0xF0, 0xD2, 0xD2, 0xC1, 0x95 
    }; 
    
    return Arrays.equals(scrambled, expected); 
    
} 

}
