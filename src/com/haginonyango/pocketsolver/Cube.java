import java.util.*;

public class Cube
{
    private final int 
        TOP = 0, 
        LEFT = 1, 
        FRONT = 2, 
        RIGHT = 3, 
        BACK = 4, 
        BOTTOM = 5;

    private final int [][] cube;

    public static void main(String[] args) {
        Cube c = Cube.random();
        System.out.println(c);
        Cube.solve(c);
    }

    static public void solve(Cube c) {
        Set<Cube> cubesFound = new HashSet<Cube>();
        cubesFound.add(c);

        Stack<Cube> s = new Stack<Cube>();
        s.push(c);

        Set<Stack<Cube>> initialPaths = new HashSet<Stack<Cube>>();
        initialPaths.add(s);

        solve(initialPaths, cubesFound);
    }

    static public void solve(Set<Stack<Cube>> livePaths, Set<Cube> cubesFoundSoFar) {
        System.out.println("livePaths size:" + livePaths.size());
        int numDupes = 0;

        Set<Stack<Cube>> newLivePaths = new HashSet<Stack<Cube>>();

        for (Stack<Cube> currentPath : livePaths) {

            Set<Cube> nextStates = currentPath.peek().getNextStates();

            for (Cube next : nextStates) {
                if (currentPath.size() > 1 && next.isSolved()) {
                    currentPath.push(next);
                    System.out.println("Path length:" + currentPath.size());
                    System.out.println("Path:" + currentPath);
                    System.exit(0);

                } else if (!cubesFoundSoFar.contains(next)) {
                    Stack<Cube> newCurrentPath = new Stack<Cube>();
                    newCurrentPath.addAll(currentPath);
                    newCurrentPath.push(next);
                    newLivePaths.add(newCurrentPath);
                    cubesFoundSoFar.add(next);
                } else {
                    numDupes += 1;
                }
            }
        }

        System.out.println("Duplicates found " + numDupes + ".");
        solve(newLivePaths, cubesFoundSoFar);
    }

    static public Cube random() {
        Cube c = new Cube();
        Random rand = new Random();
        for (int i = 0; i < 24; i++) {
            int f = rand.nextInt(6);
            Cube newCube = new Cube(c);
            if (f == 0) {
                newCube.rotateFrontCCW();
            }
            else if (f == 1) {
                newCube.rotateFrontCW();
            }
            else if (f == 2) {
                newCube.rotateFrontCW();
                newCube.rotateFrontCW();
            }
            else if (f == 3) {
                newCube.rotateRightCW();
            }
            else if (f == 4) {
                newCube.rotateRightCCW();
            }
            else if (f == 5) {
                newCube.rotateRightCCW();
                newCube.rotateRightCCW();
            }
            c = newCube;
        }
        return c;
    }

    private Cube() {
        cube = new int[][] {
            { 0, 0, 0, 0 },
            { 1, 1, 1, 1 },
            { 2, 2, 2, 2 },
            { 3, 3, 3, 3 },
            { 4, 4, 4, 4 },
            { 5, 5, 5, 5 }
        };
    }

    private Cube(Cube other) {
        cube = new int[other.cube.length][];
        for (int i = 0; i < other.cube.length; i++) {
            cube[i] = Arrays.copyOf(other.cube[i], other.cube[i].length);
        }
    }

    public boolean isSolved() {
        for (int i = 0; i < cube.length; i++) {
            for (int k = 1; k < cube[i].length; k++) {
                if (cube[i][0] != cube[i][k]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Cube && Arrays.deepEquals(((Cube) other).cube, cube);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(cube);
    }

    @Override
    public String toString() {
        final String NL = System.lineSeparator();
        String acc = NL;
        acc += "   " + cube[TOP][0] + cube[TOP][1] + NL;
        acc += "   " + cube[TOP][2] + cube[TOP][3] + NL;

        acc += "" + cube[LEFT][0] + cube[LEFT][1] + " " + cube[FRONT][0] + cube[FRONT][1] + " " + cube[RIGHT][0] + cube[RIGHT][1] + " " + cube[BACK][0] + cube[BACK][1] + NL;
        acc += "" + cube[LEFT][2] + cube[LEFT][3] + " " + cube[FRONT][2] + cube[FRONT][3] + " " + cube[RIGHT][2] + cube[RIGHT][3] + " " + cube[BACK][2] + cube[BACK][3] + NL;

        acc += "   " + cube[BOTTOM][0] + cube[BOTTOM][1] + NL;
        acc += "   " + cube[BOTTOM][2] + cube[BOTTOM][3] + NL;
        return acc;
    }

    public Set<Cube> getNextStates() {
        Set<Cube> s = new HashSet<Cube>();

        Cube c = new Cube(this);
        c.rotateFrontCCW();
        s.add(c);

        c = new Cube(this);
        c.rotateFrontCCW();
        c.rotateFrontCCW();
        s.add(c);

        c = new Cube(this);
        c.rotateFrontCW();
        s.add(c);

        c = new Cube(this);
        c.rotateRightCW();
        s.add(c);

        c = new Cube(this);
        c.rotateRightCW();
        c.rotateRightCW();
        s.add(c);

        c = new Cube(this);
        c.rotateRightCCW();
        s.add(c);

        return s;
    }

    private void rotateFrontCCW() {
        rotateFaceCCW(FRONT);

        int temp1 = cube[TOP][2];
        int temp2 = cube[TOP][3];

        cube[TOP][2] = cube[RIGHT][0];
        cube[TOP][3] = cube[RIGHT][2];

        cube[RIGHT][0] = cube[BOTTOM][1];
        cube[RIGHT][2] = cube[BOTTOM][0];

        cube[BOTTOM][0] = cube[LEFT][1];
        cube[BOTTOM][1] = cube[LEFT][3];

        cube[LEFT][1] = temp2;
        cube[LEFT][3] = temp1;
    }

    private void rotateFrontCW() {
        rotateFaceCW(FRONT);

        int temp1 = cube[TOP][2];
        int temp2 = cube[TOP][3];

        cube[TOP][2] = cube[LEFT][3];
        cube[TOP][3] = cube[LEFT][1];

        cube[LEFT][1] = cube[BOTTOM][0];
        cube[LEFT][3] = cube[BOTTOM][1];

        cube[BOTTOM][0] = cube[RIGHT][2];
        cube[BOTTOM][1] = cube[RIGHT][0];

        cube[RIGHT][0] = temp1;
        cube[RIGHT][2] = temp2;
    }

    private void rotateRightCCW() {
        rotateFaceCCW(RIGHT);

        int temp1 = cube[TOP][1];
        int temp2 = cube[TOP][3];

        cube[TOP][3] = cube[BACK][0];
        cube[TOP][1] = cube[BACK][2];

        cube[BACK][0] = cube[BOTTOM][3];
        cube[BACK][2] = cube[BOTTOM][1];

        cube[BOTTOM][1] = cube[FRONT][1];
        cube[BOTTOM][3] = cube[FRONT][3];

        cube[FRONT][1] = temp1;
        cube[FRONT][3] = temp2;
    }

    private void rotateRightCW() {
        rotateFaceCW(RIGHT);

        int temp1 = cube[TOP][1];
        int temp2 = cube[TOP][3];

        cube[TOP][1] = cube[FRONT][1];
        cube[TOP][3] = cube[FRONT][3];

        cube[FRONT][1] = cube[BOTTOM][1];
        cube[FRONT][3] = cube[BOTTOM][3];

        cube[BOTTOM][1] = cube[BACK][2];
        cube[BOTTOM][3] = cube[BACK][0];

        cube[BACK][2] = temp1;
        cube[BACK][0] = temp2;
    }

    private void rotateFaceCW(int faceNum) {
        int[] face = cube[faceNum];
        int temp = face[0];
        face[0] = face[2];
        face[2] = face[3];
        face[3] = face[1];
        face[1] = temp;
    }

    private void rotateFaceCCW(int faceNum) {
        int[] face = cube[faceNum];
        int temp = face[0];
        face[0] = face[1];
        face[1] = face[3];
        face[3] = face[2];
        face[2] = temp;
    }

}
