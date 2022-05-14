package nsh.codility;

public class BugWars2022A implements BugWars2022Interface {

  int fuel[][];

  void updateFuel(int i, int j, int fuelBefore, int distance, int newFuel) {
    if (fuelBefore >= distance)
      fuel[i][j] = Math.max(fuel[i][j], fuelBefore - distance + newFuel);
  }

  public int solution(int[] A, int[] X) {
    int R = 1;
    int n = A.length;
    fuel = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        fuel[i][j] = -1;
      fuel[i][i] = A[i];
    }

    for (int i = n - 2; i >= 0; i--)
      for (int j = i + 1; j < n; j++) {
        updateFuel(i, j, fuel[i][j - 1], X[j] - X[j - 1], A[j]); // [i to j-1] to j
        updateFuel(i, j, fuel[j - 1][i], X[j] - X[i], A[j]); // [j-1 to i] to j
        updateFuel(j, i, fuel[j][i + 1], X[i + 1] - X[i], A[i]); // [j to i+1] to i
        updateFuel(j, i, fuel[i + 1][j], X[j] - X[i], A[i]); // [i+i to j] to i

        if (fuel[i][j] >= 0 || fuel[j][i] >= 0)
          R = Math.max(R, j - i + 1);
      }

    return R;
  }
}
