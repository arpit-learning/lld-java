## STEP 0-Questions for the interviewer?

1. What do you want me to design?

- E2E working code

2. Do we need a persistent system?

- In memory

3. How do we interact with the system?

- Command line

## STEP 1-Requirement Gathering

1. We can have N*N board.
2. We can have N-1 players.
3. Each player can choose their symbol at the start of the game.
4. Each symbol should be unique.
5. Winning conditions
    - same symbol in a row.
    - same symbol in a column.
    - same symbol in a diagonal.
    - If the same symbol is placed in all the corners.
6. Undo if possible.
7. Draw condition
    - All the cells are full, and we don't have a winner.
    - If at any point, all the columns, rows, all the four corners and diagonals have more than one type of symbol.
8. We can have bots in the game.
9. Bots will have different difficulty levels—easy, medium, hard.
10. We will maintain a list of all the players at the start and will shuffle the list. The game will be played in the
    order of the shuffled list.
11. The game ends as soon as there is a winner or the game becomes draw. After the same, we will start the game with a
    new empty board.
12. We will show the replay of the game.

## Step 2-Class Diagram

1. Player Class
2. Board Class
3. Game Class
4. Bot Class
5. Cell Class
6. PlayerType Enum
7. Difficulty Enum
8. CellState Enum
