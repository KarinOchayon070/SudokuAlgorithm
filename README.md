Hi guys,

In the third year of my computer studies degree, as part of an advanced Java development course, I developed a Java fx Sudoku application.
This application is developed in a client-server architecture and has three different repositories:

The algorithm repository   - https://github.com/KarinOchayon070/sudokuAlgorithm.
The server side repository - https://github.com/KarinOchayon070/SudokuServer.
The client side repository - https://github.com/KarinOchayon070/SudokuClient.

🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢

Before I start to explain about the algorithm part, a little bit about the sudoku game:

How to play sudoku?
A Sudoku board consists of a 9x9 grid of squares, subdivided into 3x3 squares, therefore, the total number of slots is 81. At the end of the game, each slot
will contain exactly one number. In the beginning, some slots have numbers, and the player tries to complete the other slots using the following rules:
(1) Each slot must contain a single number between 1 and 9.
(2) Each column can only contain numbers from 1 to 9 once.
(3) Each row must contain numbers from 1 to 9 once.
(4) Each 3x3 square must contain numbers from 1 to 9 once.

![image](https://user-images.githubusercontent.com/92684210/219617704-06079975-ead5-446f-a014-63a06cb775a3.png)

🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢🔢

My algorithms:

I create the "IBacktrackingAlg" interface two classes that implement the "IBacktrackingAlg" interface - "BitMaskAlgo" and "DFSAlgo".
These classes use backtracking to solve Sudoku puzzles, but use different approaches to the backtracking algorithm. 

Backtracking Algorithm (interface) - In sudoKo solving Problem, we try filling digits one by one. Whenever we find that current digit cannot lead to a solution, we remove it
(backtrack) and try next digit. This is better than naive approach (generating all possible combinations of digits and then trying every combination one by one)
as it drops a set of permutations whenever it backtracks. In backtracking solution algo, we iterate through the matrix and whenever an empty cell (cell with the digit 0)
is found, we assign a digit to the cell, where such digit is not present in the current column, row, and 3×3 submatrix.
After assigning the digit to the current cell, we recursively check whether this assignment leads to a valid solution or not.
If the assignment doesn’t lead to a valid solution, then we try the next valid digit for the current empty cell. And if none of the digits leads to a valid solution,
then the instance is infeasible.

Sudoku using DFS with backtracking (class) - The Depth-first Search is a “blind” search algorithm that can be used to find a solution to problems that can be modeled as graphs.
It’s called “blind” because this algorithm doesn’t care about the cost between vertices on the graph.
The algorithm starts from a root node and explores as far as possible along each branch before backtracking.
If the algorithm finds a solution then it returns the solution and stops the search.

Sudoku using bitMask with backtracking (class) - The BitMask algorithm solves a Sudoku puzzle by using a bit representation of a number (represented as a binary string)
to keep track of the possibilities of each cell.
The algorithm first sets the initial values of the board and maps the values to the corresponding bitmasks.
It then uses a recursive backtracking approach to assign a number to an empty cell, check if the number is safe to be placed in that cell
(i.e., it is not already present in the same row, column, or submatrix), and if it is, it assigns the number to the cell and updates the corresponding bitmasks.
If there is no safe number for a particular cell, the algorithm backtracks to the previous cell and tries another number until it finds a valid solution for the entire puzzle.
The algorithm continues this process until it fills in all the empty cells and finds a valid solution.
Finally, it prints the solved puzzle or returns false if no solution exists.
