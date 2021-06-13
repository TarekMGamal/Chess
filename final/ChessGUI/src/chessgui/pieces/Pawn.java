package chessgui.pieces;

import chessgui.Board;

import java.util.ArrayList;

public class Pawn extends Piece {

    private boolean has_moved;

    public Pawn(int x, int y, boolean is_white) {
        super(x, y, is_white);
        has_moved = false;
    }

    public Pawn(int x, int y) {
        super(x, y);
    }

    public void setHasMoved(boolean has_moved) {
        this.has_moved = true;
    }

    public boolean getHasMoved() {
        return has_moved;
    }

    @Override
    public boolean canMove(int Column, int Row) {

        // Remember: A pawn may only move towards the oponent's side of the board.
        // If the pawn has not moved yet in the game, for its first move it can 
        // move two spaces forward. Otherwise, it may only move one space. 
        // When not attacking it may only move straight ahead.
        // When attacking it may only move space diagonally forward

        // WRITE CODE HERE
        int Columns_to_move = (this.getX() - Column);
        int Row_to_move = (this.getY() - Row);
        Piece PieceInPosition = Board.getPiece(Column, Row);
        //white normal moves
        if(this.isWhite()==true) {
            if (Columns_to_move == 0) {
                if (Row_to_move == 1) {
                    if (PieceInPosition != null)
                        return false;

                    else {
                        return true;
                    }
                }

                Piece temp = Board.getPiece(this.getX(), this.getY()-1);
                if (Row_to_move == 2) {
                    if (PieceInPosition != null) {
                        return false;}
                    else {
                        if(this.getY()==6)
                        {
                            if(temp!=null)
                                return false;
                                else
                            return true;
                        }
                    }

                }
            }
            if(Columns_to_move==1||Columns_to_move==-1)
            {
                if(Row_to_move==1&& PieceInPosition!=null)
                {
                    if(PieceInPosition.isBlack()==true)
                    return true;
                }

            }
        }
        //black normal moves
        if(this.isBlack()==true)
        {
            if(Columns_to_move==0) {
                if (Row_to_move == -1) {
                    if (PieceInPosition != null) {
                        return false;
                    } else
                        return true;
                }
                Piece temp = Board.getPiece(this.getX(), this.getY()+1);
                if (Row_to_move == -2)
                    if (PieceInPosition != null)
                        return false;
                    else {
                        if (this.getY() == 1) {
                            if(temp!=null)
                                return false;
                            else
                            return true;
                        }
                    }
            }
            if(Columns_to_move==1||Columns_to_move==-1)
            {
                if(Row_to_move==-1&& PieceInPosition!=null)
                {
                    if(PieceInPosition.isWhite()==true)
                        return true;
                }

            }
        }
//eating for white


return false;
    }
        @Override
    public ArrayList<Move> validMoves(int x, int y){
        ArrayList<Move> moves = new ArrayList<Move>();

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (canMove(i, j))
                    moves.add(new Move(i, j));
            }


//		if(isWhite()) {
//			// forward
//			if(canMove(x,y+1))
//				moves.add(new Move(x,y+1));
//                       
//			
//			// kill diagonally
//			if(canMove(x+1,y+1))
//				moves.add(new Move(x+1,y+1));
//			
//			// kill diagonally
//			if(canMove(x-1,y+1))
//				moves.add(new Move(x-1,y+1));
//		}
//		else {
//			// forward
//			if(canMove(x,y-1))
//				moves.add(new Move(x,y-1));
//			
//			// kill diagonally
//			if(canMove(x+1,y-1))
//				moves.add(new Move(x+1,y-1));
//			
//			// kill diagonally
//			if(canMove(x-1,y-1))
//				moves.add(new Move(x-1,y-1));
//		}
//		
		return moves;
    }
}



//till here is the conditions of having piece where he is going to
        /*if(isWhite()){
        if(this.getHasMoved()==false)
        {
            if(columns_to_move==0){
                if(Row_to_move==1)
                {
                    return true ;
                }
            if(Row_to_move==2)
            {
                Piece Temp=Board.getPiece(Column,Row-1);
                if(Temp!=null)
                    return false;
                else
                    return true ;

            }
            }
        }
        else
            if(columns_to_move==0&&Row_to_move==1)
            {   //this.setHasMoved(true);
                return true;
            }
    }

              if(this.isBlack()){
        if(this.getHasMoved()==false)
        {
             if(columns_to_move==0){
                if(Row_to_move==-1)
                {
                    //this.setHasMoved(true);
                    return true ;
                }
            if(Row_to_move==-2)
            {
                Piece Temp=Board.getPiece(Column,Row+1);
                if(Temp!=null)
                    return false;
                else
                    return true ;

            }
            }


        }
        else
            if(columns_to_move==0&&Row_to_move==-1)
            {
                this.setHasMoved(true);
                return true;
            }
              }

              if(PieceInPosition!=null)
              {
//there  is a piece in this pos and we can eat it as a white piece
                  if(PieceInPosition.isBlack()&&this.isWhite())
                      if(columns_to_move==1||columns_to_move==-1)
                          if(Row_to_move==1)
                          return true;

              }




              if(PieceInPosition!=null)
              {//there  is a piece in this pos and we can eat it as a Black piece
                  if(PieceInPosition.isWhite()&&this.isBlack())
                      if(columns_to_move==1||columns_to_move==-1)
                          if(Row_to_move==-1)
                          return true;

              }




       return false;
    }
    */


