#include <iostream>
#include <vector>
#include<bits/stdc++.h>
using namespace std;

class NQueenSolver {
public:
    void backtrack(int col, int n, vector<string>& board, vector<vector<string>>& output,
                   vector<int>& rowCheck, vector<int>& lowDiag, vector<int>& upDiag) {
        if (col == n) {
            output.push_back(board);
            return;
        }

        for (int r = 0; r < n; r++) {
            if (rowCheck[r] == 0 && lowDiag[r + col] == 0 && upDiag[n - 1 + col - r] == 0) {
                board[r][col] = 'Q';
                rowCheck[r] = lowDiag[r + col] = upDiag[n - 1 + col - r] = 1;

                backtrack(col + 1, n, board, output, rowCheck, lowDiag, upDiag);

                board[r][col] = '.'; 
                rowCheck[r] = lowDiag[r + col] = upDiag[n - 1 + col - r] = 0;
            }
        }
    }

    vector<vector<string>> getSolutions(int n) {
        vector<vector<string>> result;
        vector<string> grid(n, string(n, '.'));
        vector<int> row(n, 0), ldiag(2 * n - 1, 0), udiag(2 * n - 1, 0);

        backtrack(0, n, grid, result, row, ldiag, udiag);
        return result;
    }
};

int main() {
    int size = 4;
    NQueenSolver solver;
    vector<vector<string>> res = solver.getSolutions(size);

    cout << "Output: [";
    for (int i = 0; i < res.size(); i++) {
        cout << "[";
        for (int j = 0; j < res[i].size(); j++) {
            cout << "\"" << res[i][j] << "\"";
            if (j != res[i].size() - 1) cout << ",";
        }
        cout << "]";
        if (i != res.size() - 1) cout << ",";
    }
    cout << "]\n";

    return 0;
}
