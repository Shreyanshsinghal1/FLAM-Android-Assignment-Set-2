#include <iostream>
#include <vector>
using namespace std;

bool detectCycleFrom(int curr,
                     const vector<vector<int>>& graph,
                     vector<bool>& seen,
                     vector<bool>& inStack) {
    seen[curr] = true;
    inStack[curr] = true;

    for (int next : graph[curr]) {
        if (!seen[next]) {
            if (detectCycleFrom(next, graph, seen, inStack)) {
                return true;  
            }
        }
        else if (inStack[next]) {
            return true;
        }
    }

   
    inStack[curr] = false;
    return false;
}


bool hasCircularDependency(int moduleCount, vector<vector<int>>& relations) {
    
    vector<vector<int>> graph(moduleCount);
    for (auto& pair : relations) {
        int from = pair[0];
        int to   = pair[1];
        graph[from].push_back(to);
    }

    vector<bool> seen(moduleCount, false);
    vector<bool> inStack(moduleCount, false);

    for (int i = 0; i < moduleCount; ++i) {
        if (!seen[i]) {
            if (detectCycleFrom(i, graph, seen, inStack)) {
                return true;
            }
        }
    }
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;
    vector<vector<int>> relations;
    relations.reserve(m);

    for (int i = 0; i < m; ++i) {
        int a, b;
        cin >> a >> b;
        relations.push_back({ a, b });
    }

    bool foundCycle = hasCircularDependency(n, relations);
    if (foundCycle) {
        cout << "true";
    } else {
        cout << "false";
    }
    return 0;
}
