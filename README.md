# Simple Fire Spread Simulation
This project simulates the spread of a wildfire in a forest, using a 2D array for our fictional forest and JFrames to illustrate the spread.

## Purpose:
- Practice using 2D arrays and performing operations on the array
- Practice using JFrames for illustration

## How the Project Works:
- Upon execution, you will be prompted for 2 inputs
  1. __The size of the forest__: You will provide a positive integer for the length of our square forest (if you provide an integer less than 0, the world size will default to 25)
  2. __The probability for a tree to catch fire__: You will provide a number from 0 to 1 for the probability (if you provide a number less than 0 or greater than 1, the probability will default to .4)
- Then a window will open containing _Green_, _Yellow_, and _Red_ 'cells'
  - _Green_ cells represent trees
  - _Yellow_ cells represent open space/burned trees
  - _Red_ cells represent trees currently on fire
- To update the forest, we iterate through the cells looking for _Red_ cells. Upon each find, we update 9 cells (the source cell and the 8 surrounding cells in the grid):
  - _Yellow_ cells remain unchanged
  - _Red_ cells turn _Yellow_
  - _Green_ cells either turn _Red_ or remain unchanged (depending on if a random number from 0-1 is below the probability range)
- The program ends when you exit the JFrame window
