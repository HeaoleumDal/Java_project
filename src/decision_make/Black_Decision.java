package decision_make;

import game.UI.chess;
import game.location.Location;
import decision_make.Decision_Making;

public class Black_Decision {
    private int[][] Import_Board = new int[8][8];
    private int[][] Settlexy = new int[20][2];
    private int Each_Max; // 각 말들이 가질 수 있는 최대값
    private int max; // 각 팀에서 가질 수 있는 최대값
    private int max_x, max_y;
    private int max_next_x, max_next_y;
    public int count = 0;
    Location location = new Location();

    public void Main_Black_Move(){ // 실제로 호출되는 함수는 이 함수 뿐임
      clear();
      BlackImporting_Board(chess.chessboard);
    }

    public void clear(){
      Black_Decision Import_Board = new int[8][8];
      Black_Decision Settlexy = new int[20][2];
      Each_Max = 0;
      max = 0, max_x =0, max_y = 0, max_next_x = 0, max_next_y = 0, count = 0;
    }

    public void BlackImporting_Board(String[][] CI_Board) {
        count = 0;
        for (int i = 0; i < 8; i++) { // 의사 결정을 위한 기본적인 세팅
            for (int j = 0; j < 8; j++) {
                Importing_Board(i, j, CI_Board); // Update된 자신의 보드에 중요도 부여
                Settling_Board(i, j); // 각 말의 위치를 가져옴
            }
        }
        for (int i = 0; i < 20; i++) { // 각 말이 갖는 중요도의 최댓값을 저장해줌
          Check_Import(Settlexy[i][0], Settlexy[i][1]);
        }
    }
    public void SwapMax(int x, int y, int m_x, int m_y) {
        max = Import_Board[x + m_x][y + m_y];
        max_x = x;
        max_y = y;
        max_next_x = x + m_x;
        max_next_y = y + m_y;
    }

    public void Check_Import(int now_dx, int now_dy) {
        int max = 0;
        // Pawn Move
        if (location.LocationPiece(now_dx, now_dy) == chess.BlackPawn) {
            if ((now_dx + 1 <= 0)) {
                if (max < Import_Board[now_dx + 1][now_dy]) {
                    SwapMax(now_dx, now_dy, 1, 0);
                }
            } else if ((now_dx + 2 <= 0 && now_dy == 1)) {
                if (max < Import_Board[now_dx + 1][now_dy]) {
                    SwapMax(now_dx, now_dy, 2, 0);
                }
            }
        }
        // Rook Move
        if (location.LocationPiece(now_dx, now_dy) == chess.BlackRook) {
            for (int i = 1; i <= 7; i++) {
                if (now_dx + i <= 7) {
                    if (max < Import_Board[now_dx + i][now_dy]) {
                        SwapMax(now_dx, now_dy, i, 0);
                    }
                }
                if (now_dx - i >= 0) {
                    if (max < Import_Board[now_dx - i][now_dy]) {
                        SwapMax(now_dx, now_dy, -i, 0);
                    }
                }
                if (now_dy + i <= 7) {
                    if (max < Import_Board[now_dx][now_dy + i]) {
                        SwapMax(now_dx, now_dy, 0, i);
                    }
                }
                if (now_dy - i >= 0) {
                    if (max < Import_Board[now_dx][now_dy - i]) {
                        SwapMax(now_dx, now_dy, 0, -i);
                    }
                }
            }
        }
        // Knight Move
        if (location.LocationPiece(now_dx, now_dy) == chess.BlackKnight) {
            if (now_dx - 2 >= 0 && now_dy - 1 >= 0) {
                if (max < Import_Board[now_dx - 2][now_dy - 1]) {
                    SwapMax(now_dx, now_dy, -2, -1);
                }
            }
            if (now_dx - 2 >= 0 && now_dy + 1 <= 7) {
                if (max < Import_Board[now_dx - 2][now_dy + 1]) {
                    SwapMax(now_dx, now_dy, -2, 1);
                }
            }
            if (now_dx - 1 >= 0 && now_dy - 2 >= 0) {
                if (max < Import_Board[now_dx - 1][now_dy - 2]) {
                    SwapMax(now_dx, now_dy, -1, -2);
                }
            }
            if (now_dx - 1 >= 0 && now_dy + 2 <= 7) {
                if (max < Import_Board[now_dx - 1][now_dy + 2]) {
                    SwapMax(now_dx, now_dy, -1, 2);
                }
            }
            if (now_dx + 1 <= 7 && now_dy - 2 >= 0) {
                if (max < Import_Board[now_dx + 1][now_dy - 2]) {
                    SwapMax(now_dx, now_dy, 1, -2);
                }
            }
            if (now_dx + 1 <= 7 && now_dy + 2 <= 7) {
                if (max < Import_Board[now_dx - 2][now_dy - 1]) {
                    SwapMax(now_dx, now_dy, 1, 2); // 수정 요망
                }
            }
            if (now_dx + 2 <= 7 && now_dy - 1 >= 0) {
                if (max < Import_Board[now_dx + 2][now_dy - 1]) {
                    SwapMax(now_dx, now_dy, 2, -1);
                }
            }

            if (now_dx + 2 <= 7 && now_dy + 1 <= 7) {
                if (max < Import_Board[now_dx + 2][now_dy + 1]) {
                    SwapMax(now_dx, now_dy, 2, 1);
                }
            }
        }
        // Bishop Move
        if (location.LocationPiece(now_dx, now_dy) == chess.BlackBishop
                || location.LocationPiece(now_dx, now_dy) == chess.WhiteBishop) {
            for (int i = 1; i <= 7; i++) {
                if ((now_dx + i <= 7) && (now_dy + i <= 7)) {
                    if (max < Import_Board[now_dx + i][now_dy + i]) {
                        SwapMax(now_dx, now_dy, i, i);
                    }
                } // 아래로, 오른쪽 - 4 사분면
                if ((now_dx - i >= 0) && (now_dy + i <= 7)) {
                    if (max < Import_Board[now_dx - i][now_dy + i]) {
                        SwapMax(now_dx, now_dy, i, -i);
                    }
                } // 위로, 오른쪽 - 1 사분면
                if ((now_dx + i <= 7) && (now_dy - i >= 0)) {
                    if (max < Import_Board[now_dx + i][now_dy - i]) {
                        SwapMax(now_dx, now_dy, i, -i);
                    }
                } // 아래로, 왼쪽 - 3 사분면
                if ((now_dx - i >= 0) && (now_dy - i >= 0)) {
                    if (max < Import_Board[now_dx - i][now_dy - i]) {
                        SwapMax(now_dx, now_dy, -i, -i);
                    }
                } // 위로, 왼쪽 - 2 사분면
            }
        }
        // Queen
        if (location.LocationPiece(now_dx, now_dy) == chess.BlackQueen
                || location.LocationPiece(now_dx, now_dy) == chess.WhiteQueen) {
            for (int i = 1; i <= 7; i++) {
                if (now_dx + i <= 7) {
                    if (max < Import_Board[now_dx + i][now_dy]) {
                        SwapMax(now_dx, now_dy, i, 0);
                    }
                }
                if (now_dx - i >= 0) {
                    if (max < Import_Board[now_dx - i][now_dy]) {
                        SwapMax(now_dx, now_dy, -i, 0);
                    }
                }
                if (now_dy + i <= 7) {
                    if (max < Import_Board[now_dx][now_dy + i]) {
                        SwapMax(now_dx, now_dy, 0, i);
                    }
                }
                if (now_dy - i >= 0) {
                    if (max < Import_Board[now_dx][now_dy - i]) {
                        SwapMax(now_dx, now_dy, 0, -i);
                    }
                }
                if ((now_dx + i <= 7) && (now_dy + i <= 7)) {
                    if (max < Import_Board[now_dx + i][now_dy + i]) {
                        SwapMax(now_dx, now_dy, i, i);
                    }
                } // 아래로, 오른쪽 - 4 사분면
                if ((now_dx - i >= 0) && (now_dy + i <= 7)) {
                    if (max < Import_Board[now_dx - i][now_dy + i]) {
                        SwapMax(now_dx, now_dy, i, -i);
                    }
                } // 위로, 오른쪽 - 1 사분면
                if ((now_dx + i <= 7) && (now_dy - i >= 0)) {
                    if (max < Import_Board[now_dx + i][now_dy - i]) {
                        SwapMax(now_dx, now_dy, i, -i);
                    }
                } // 아래로, 왼쪽 - 3 사분면
                if ((now_dx - i >= 0) && (now_dy - i >= 0)) {
                    if (max < Import_Board[now_dx - i][now_dy - i]) {
                        SwapMax(now_dx, now_dy, -i, -i);
                    }
                } // 위로, 왼쪽 - 2 사분면
            }
        }
        // King
        if (location.LocationPiece(now_dx, now_dy) == chess.BlackKing
                && location.LocationPiece(now_dx, now_dy) == chess.WhiteKing) {
            if (now_dx + 1 <= 7) {
                if (max < Import_Board[now_dx + 1][now_dy]) {
                    SwapMax(now_dx, now_dy, 1, 0);
                }
            }
            if (now_dx - 1 >= 0) {
                if (max < Import_Board[now_dx - 1][now_dy]) {
                    SwapMax(now_dx, now_dy, -1, 0);
                }
            }
            if (now_dy + 1 <= 7) {
                if (max < Import_Board[now_dx][now_dy + 1]) {
                    SwapMax(now_dx, now_dy, 0, 1);
                }
            }
            if (now_dy - 1 >= 0) {
                if (max < Import_Board[now_dx][now_dy - 1]) {
                    SwapMax(now_dx, now_dy, 0, -1);
                }
            }
            if ((now_dx + 1 <= 7) && (now_dy + 1 <= 7)) {
                if (max < Import_Board[now_dx + 1][now_dy + 1]) {
                    SwapMax(now_dx, now_dy, 1, 1);
                }
            } // 아래로, 오른쪽 - 4 사분면
            if ((now_dx - 1 >= 0) && (now_dy + 1 <= 7)) {
                if (max < Import_Board[now_dx - 1][now_dy + 1]) {
                    SwapMax(now_dx, now_dy, 1, -1);
                }
            } // 위로, 오른쪽 - 1 사분면
            if ((now_dx + 1 <= 7) && (now_dy - 1 >= 0)) {
                if (max < Import_Board[now_dx + 1][now_dy - 1]) {
                    SwapMax(now_dx, now_dy, 1, -1);
                }
            } // 아래로, 왼쪽 - 3 사분면
            if ((now_dx - 1 >= 0) && (now_dy - 1 >= 0)) {
                if (max < Import_Board[now_dx - 1][now_dy - 1]) {
                    SwapMax(now_dx, now_dy, -1, -1);
                }
            } // 위로, 왼쪽 - 2 사분면
        }
    }

    public void Importing_Board(int i, int j, String[][] CI_Board) {
        if (CI_Board[i][j] == chess.WhitePawn)
            Import_Board[i][j] = 1;
        else if (CI_Board[i][j] == chess.BlackPawn)
            Import_Board[i][j] = -1; // Pawn

        else if (CI_Board[i][j] == chess.WhiteRook)
            Import_Board[i][j] = 3;
        else if (CI_Board[i][j] == chess.BlackRook)
            Import_Board[i][j] = -3; // Rook

        else if (CI_Board[i][j] == chess.WhiteKnight)
            Import_Board[i][j] = 2;
        else if (CI_Board[i][j] == chess.BlackKnight)
            Import_Board[i][j] = -2; // Knight

        else if (CI_Board[i][j] == chess.WhiteBishop)
            Import_Board[i][j] = 2;
        else if (CI_Board[i][j] == chess.BlackBishop)
            Import_Board[i][j] = -2; // Bishop

        else if (CI_Board[i][j] == chess.WhiteQueen)
            Import_Board[i][j] = 5;
        else if (CI_Board[i][j] == chess.BlackQueen)
            Import_Board[i][j] = -5; // Queen

        else if (CI_Board[i][j] == chess.WhiteKing)
            Import_Board[i][j] = 6;
        else if (CI_Board[i][j] == chess.BlackKing)
            Import_Board[i][j] = -6; // King
    }

    public void Settling_Board(int i, int j) {
        if (location.LocationPiece(i, j) == chess.BlackPawn) {
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        } else if (location.LocationPiece(i, j) == chess.BlackRook) {
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        } else if (location.LocationPiece(i, j) == chess.BlackKnight) {
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        } else if (location.LocationPiece(i, j) == chess.BlackBishop) {
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        } else if (location.LocationPiece(i, j) == chess.BlackQueen) {
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        } else if (location.LocationPiece(i, j) == chess.BlackKing) {
            Settlexy[count][0] = i;
            Settlexy[count++][1] = j;
        }
    }
}
