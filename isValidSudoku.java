// Time Complexity : O(1)
// Space Complexity : O(1)
/* Approach : Iterate over the board and at every row create new hashset of row, column
and grid of 3*3. At every column check if the cell is present in row / column / grid, if it
is present then value is repeating and it is not valid sudukoso return false
 else simply add it to the respective sets. if iteration is complete without any 
 breaks then return true as it is valid suduko.
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<board.length; i++){                  // iterate over board's row length
            HashSet<Character> row = new HashSet<>();       // initialize a row hashset at ever row
            HashSet<Character> col = new HashSet<>();       // initialize a column hashset at ever row
            HashSet<Character> grid = new HashSet<>();      // initialize a grid hashset at ever row
            for(int j=0; j<board[0].length; j++){           // iterate over board's column length
                char rv = board[i][j];                      // get current cell with row being constant and column being iterated
                if(rv != '.' && row.contains(rv)){          // validate if it is present in hashset
                    return false;                           // the value is repeating so return false as it is not valid suduko
                }
                else{
                    row.add(rv);                            // add it to hashset
                }

                char cv = board[j][i];                      // get current cell with row being iterated and column being constand
                if(cv != '.' && col.contains(cv)){          // validate if it is present in hashset
                    return false;                           // the value is repeating so return false as it is not valid suduko
                }
                else{
                    col.add(cv);                            // add it to hashset
                }

                int gr = 3 * (i/3) + j/3;                   // get row for the grid of 3*3
                int gc = 3 * (i%3) + j%3;                   // get column for the grid of 3*3
                char gv = board[gr][gc];                    // get the value in the grid

                if(gv != '.' && grid.contains(gv)){         // validate if it is present in hashset
                    return false;                           // the value is repeating so return false as it is not valid suduko
                }
                else{
                    grid.add(gv);                           // add it to hashset
                }

            }
        }
        return true;                                        // it is a valid suduko
    }
}