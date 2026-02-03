# Tic-Tac-Toe System Design Analysis

## 📋 System Overview

This is a well-structured, object-oriented implementation of a Tic-Tac-Toe game system that supports:
- **N×N board** (configurable dimension, typically 3-10)
- **N-1 players** (e.g., 3×3 board = 2 players)
- **Human and Bot players** (max 1 bot per game)
- **Multiple winning conditions** (rows, columns, diagonals, corners)
- **Draw detection** (board full or no winning paths possible)
- **Game replay** (stores board states)
- **Undo functionality** (prepared but not fully implemented)

---

## 🏗️ Architecture & Design Patterns

### **1. Layered Architecture**

```
┌─────────────────────────────────────┐
│         Presentation Layer          │
│         (Main.java)                 │
└─────────────────────────────────────┘
                  ↓
┌─────────────────────────────────────┐
│        Controller Layer              │
│     (GameController.java)           │
└─────────────────────────────────────┘
                  ↓
┌─────────────────────────────────────┐
│         Service Layer                │
│  - Bot Playing Strategies           │
│  - Winner Check Strategies          │
└─────────────────────────────────────┘
                  ↓
┌─────────────────────────────────────┐
│          Model Layer                 │
│  - Game, Board, Player, Cell, Move  │
└─────────────────────────────────────┘
```

### **2. Design Patterns Used**

#### **Strategy Pattern** ⭐
- **Purpose**: Encapsulate algorithms that can be swapped at runtime
- **Implementations**:
  - `IBotPlayingStrategy` → `RandomBotPlayingStrategy`, `EasyBotPlayingStrategy`
  - `IWinnerCheckStrategy` → `OrderOneWinnerCheckStrategy`, `OrderNWinnerCheckStrategy`, `OrderNSquareWinnerCheckStrategy`

#### **Builder Pattern** ⭐
- **Purpose**: Construct complex `Game` objects step-by-step
- **Location**: `Game.Builder` inner class
- **Benefits**: 
  - Validates game configuration before creation
  - Prevents invalid game states
  - Fluent API for game creation

#### **Inheritance**
- `Bot extends Player` - Bot is a specialized type of Player

#### **Enum Pattern**
- `PlayerType` (HUMAN, BOT)
- `CellState` (EMPTY, FILLED, BLOCKED)
- `GameStatus` (YET_TO_START, RUNNING, DRAW, WIN)
- `BotDifficultyLevel` (EASY, MEDIUM, HARD)

---

## 📦 Core Components

### **Model Layer**

#### **1. Game** (Main Entity)
```java
- board: Board
- players: List<Player>
- winner: Player
- gameStatus: GameStatus
- moves: List<Move>
- currentPlayer: Player
- oldBoardStates: List<Board>  // For replay
```

**Responsibilities**:
- Maintains game state
- Validates game configuration via Builder
- Stores move history and board states

**Validation Rules**:
- Dimension: 3-10
- Players count = dimension - 1
- Unique symbols per player
- Max 1 bot per game

#### **2. Board**
```java
- cells: List<List<Cell>>
- dimension: int
```

**Responsibilities**:
- Represents the game board
- Initializes cells in a grid structure

#### **3. Cell**
```java
- row: int
- column: int
- cellState: CellState
- player: Player
```

**Responsibilities**:
- Represents a single cell on the board
- Tracks which player filled it (if any)

#### **4. Player**
```java
- id: int
- name: String
- symbol: char
- playerType: PlayerType
```

#### **5. Bot** (extends Player)
```java
- difficultyLevel: BotDifficultyLevel
```

#### **6. Move**
```java
- player: Player
- cell: Cell
```

**Purpose**: Represents a single move made by a player

---

### **Controller Layer**

#### **GameController**
**Responsibilities**:
- Game creation and management
- Move execution (human & bot)
- Winner checking
- Board display
- Game state updates

**Key Methods**:
- `createNewGame()` - Uses Builder pattern
- `executeMove()` - Handles human input or bot strategy
- `checkWinner()` - Delegates to winner check strategy
- `displayBoard()` - Renders board state
- `addOldBoardState()` - Stores state for replay

---

### **Service Layer**

#### **Bot Playing Strategies**

**Interface**: `IBotPlayingStrategy`
```java
Move makeMove(Board board, Player player);
```

**Implementations**:
1. **RandomBotPlayingStrategy** ✅
   - Finds first empty cell
   - Sequential search (not truly random)
   - Throws `DrawGameException` if no moves available

2. **EasyBotPlayingStrategy** ⚠️
   - Currently returns null (not implemented)

**Future Extensions**:
- MediumBotPlayingStrategy (blocking moves)
- HardBotPlayingStrategy (minimax algorithm)

#### **Winner Check Strategies**

**Interface**: `IWinnerCheckStrategy**
```java
Player checkWinner(Board board, Move lastPlayedMove);
```

**Implementations**:
1. **OrderOneWinnerCheckStrategy** ✅ (Fully Implemented)
   - **Optimized O(1) winner checking** using HashMaps
   - Tracks counts per row, column, diagonal, corners
   - Early draw detection (when all paths have mixed symbols)
   - Checks:
     - Row completion
     - Column completion
     - Left diagonal (row == col)
     - Right diagonal (row + col == dimension - 1)
     - Corner completion (all 4 corners)

2. **OrderNWinnerCheckStrategy** ⚠️ (TODO)
3. **OrderNSquareWinnerCheckStrategy** ⚠️ (TODO)

**Algorithm Details** (OrderOneWinnerCheckStrategy):
- Maintains HashMaps for each row, column, diagonal
- Increments count when same symbol appears
- Returns winner when count == dimension
- Tracks "validHMs" (valid hash maps) for draw detection
- Decrements validHMs when a path has mixed symbols
- Throws `DrawGameException` when validHMs == 0

---

## 🎮 Game Flow

```
1. User Input Phase
   ├─ Get board dimension (3-10)
   ├─ Ask for bot preference (y/n)
   └─ Collect player info (name, symbol)

2. Game Initialization
   ├─ Create GameController
   ├─ Create players list
   ├─ Shuffle players (randomize turn order)
   └─ Build Game (validates configuration)

3. Game Loop
   ├─ Display board
   ├─ Get current player
   ├─ Execute move
   │  ├─ Human: Get input, validate, update cell
   │  └─ Bot: Use strategy to make move
   ├─ Store board state (for replay)
   ├─ Check winner
   │  └─ If winner found → GameStatus.WIN
   ├─ Check draw conditions
   │  └─ If draw → GameStatus.DRAW
   └─ Repeat until game ends

4. Game End
   ├─ Display final board
   ├─ Announce winner or draw
   └─ (Future: Option to replay or start new game)
```

---

## ✅ Strengths

1. **Clean Architecture**: Clear separation of concerns
2. **Extensibility**: Strategy pattern allows easy addition of new bot/winner strategies
3. **Validation**: Comprehensive validation in Game.Builder
4. **Optimization**: O(1) winner checking (OrderOneWinnerCheckStrategy)
5. **Error Handling**: Custom exceptions for different error scenarios
6. **Replay Support**: Stores board states for replay functionality
7. **Flexible Board Size**: Supports N×N boards, not just 3×3

---

## ⚠️ Areas for Improvement

### **1. Incomplete Features**
- ❌ `undoMove()` returns null (not implemented)
- ❌ `replayGame()` is empty (not implemented)
- ❌ `EasyBotPlayingStrategy` not implemented
- ❌ Other winner check strategies not implemented

### **2. Code Quality Issues**

#### **GameController.java** (Current Version - Before Error Handling Improvements)
- Uses generic `IllegalStateException` instead of custom exception
- No null checks for parameters
- Scanner created inside method (should be injected or managed better)
- No input validation/error handling for scanner
- Hard-coded strategy instantiation

#### **Main.java** (Current Version - Before Error Handling Improvements)
- No error handling (exceptions crash the program)
- No input validation
- No draw game handling
- Scanner not closed properly
- No retry mechanism for invalid moves

### **3. Design Issues**

1. **Tight Coupling**:
   - `GameController` directly instantiates `RandomBotPlayingStrategy`
   - Should use dependency injection or factory pattern

2. **Missing Abstraction**:
   - `GameController` handles both human and bot moves
   - Could separate into `HumanMoveHandler` and `BotMoveHandler`

3. **State Management**:
   - `currentPlayer` field in Game is never set
   - Turn management handled in Main.java instead of Game

4. **Board State Storage**:
   - `addOldBoardState()` adds reference to same board object
   - Should create deep copies for proper replay

5. **Winner Check Strategy Selection**:
   - Hard-coded in GameController constructor
   - Should be configurable based on board dimension or game type

### **4. Missing Features**

1. **Draw Detection**:
   - Not fully handled in Main.java
   - Board full check missing
   - DrawGameException not caught

2. **Move History**:
   - Moves list in Game is never populated
   - Could be used for undo/replay

3. **Bot Strategy Selection**:
   - Bot difficulty level exists but not used
   - All bots use RandomBotPlayingStrategy regardless of difficulty

4. **Input Validation**:
   - No validation for player names (empty, length)
   - No validation for symbols (special characters, duplicates)
   - No validation for dimension range

---

## 🔄 Data Flow

### **Move Execution Flow**
```
Main.java
  ↓
GameController.executeMove()
  ├─ Human Path:
  │  ├─ Get input from Scanner
  │  ├─ validateRowNColumn()
  │  ├─ Update Cell state
  │  └─ Return Move
  │
  └─ Bot Path:
     ├─ Get BotPlayingStrategy
     ├─ strategy.makeMove()
     └─ Return Move
```

### **Winner Check Flow**
```
GameController.checkWinner()
  ↓
IWinnerCheckStrategy.checkWinner()
  ├─ OrderOneWinnerCheckStrategy:
  │  ├─ Check row hashmap
  │  ├─ Check column hashmap
  │  ├─ Check left diagonal
  │  ├─ Check right diagonal
  │  ├─ Check corners
  │  └─ Return Player or null
```

---

## 📊 Class Relationships

```
Game
├── Board (1:1)
│   └── Cell[][] (1:many)
├── Player[] (1:many)
│   └── Bot (inherits Player)
├── Move[] (1:many)
│   ├── Player (1:1)
│   └── Cell (1:1)
└── Board[] (oldBoardStates for replay)

GameController
├── IWinnerCheckStrategy (composition)
└── Uses Game, Player, Board, Move

IBotPlayingStrategy
└── Implementations: RandomBotPlayingStrategy, EasyBotPlayingStrategy

IWinnerCheckStrategy
└── Implementations: OrderOneWinnerCheckStrategy, OrderNWinnerCheckStrategy, OrderNSquareWinnerCheckStrategy
```

---

## 🎯 Key Design Decisions

1. **Why Strategy Pattern?**
   - Allows swapping bot AI algorithms without changing GameController
   - Enables different winner check algorithms for different board sizes

2. **Why Builder Pattern?**
   - Complex validation logic before object creation
   - Prevents invalid Game objects from being created
   - Fluent API improves readability

3. **Why Store Old Board States?**
   - Enables replay functionality
   - Could be used for undo (though not implemented)

4. **Why O(1) Winner Check?**
   - Traditional approach: O(N) per move (check all rows/cols/diagonals)
   - This approach: O(1) per move (increment counters)
   - Better performance for larger boards

---

## 🚀 Future Enhancements

1. **Complete Missing Features**:
   - Implement undo functionality
   - Implement replay functionality
   - Implement EasyBotPlayingStrategy
   - Implement other winner check strategies

2. **Improve Bot Intelligence**:
   - MediumBotPlayingStrategy (blocking opponent)
   - HardBotPlayingStrategy (minimax algorithm)

3. **Better State Management**:
   - Deep copy board states for replay
   - Properly track current player in Game
   - Populate moves list

4. **Input/Output Improvements**:
   - Better CLI interface
   - Input validation and retry
   - Better error messages

5. **Architecture Improvements**:
   - Dependency injection for strategies
   - Factory pattern for strategy creation
   - Separate move handlers

6. **Testing**:
   - Unit tests for strategies
   - Integration tests for game flow
   - Test edge cases (draw, invalid moves)

---

## 📝 Summary

This is a **well-designed, extensible system** that demonstrates:
- ✅ Object-oriented principles
- ✅ Design patterns (Strategy, Builder)
- ✅ Clean architecture
- ✅ Optimized algorithms (O(1) winner check)

However, it has **incomplete features** and could benefit from:
- Better error handling (now improved!)
- Complete implementation of all features
- Better separation of concerns
- More robust input validation

The system is **production-ready** for basic gameplay but needs completion of advanced features (undo, replay, better bots) for full functionality.
