#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int currentfloor,n,x;
    cout<<"enter the total number of floors:";
    cin>>x;
    cout << "enter the current floor of the elevator: ";
    cin >> currentfloor;
    if(currentfloor>x)
    {
        cout<<"invalid floor";
        return 0;
    }
    cout << "enter the number of requesting floors: ";
    cin >> n;
    int requestedfloors[n];
    for (int i = 0; i < n; i++) {
        cout << "enter the"<<i+1<<"requesting floor:";
        cin >> requestedfloors[i];
    }
    sort(requestedfloors,requestedfloors+n);
    int nearestfloors[n];
    int visited[n] = {0};
    int i = 0;
    while (i < n) {
        int nearestdistance = INT_MAX;
        int nearestfloor;
        int nearestindex;
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                int distance = abs(requestedfloors[j] - currentfloor);
                if (distance < nearestdistance) {
                    nearestdistance = distance;
                    nearestfloor = requestedfloors[j];
                    nearestindex = j;
                }
            }
        }
        nearestfloors[i] = nearestfloor;
        visited[nearestindex] = 1;
        currentfloor = nearestfloor;
        i++;
    }
    cout << "The order in which the lift goes is: ";
    for (int i = 0; i < n; i++) {
        cout << nearestfloors[i] << " ";
    }
    cout << endl;
    return 0;
}
