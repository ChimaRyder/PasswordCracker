public class CrackerRunnable implements Runnable{
    char start;
    String pass;
    static boolean isFound = false;

    public CrackerRunnable(char start, String pass) {
        this.start = start;
        this.pass = pass;
    }

    @Override
    public void run() {
        //from ch+"aaaaa..." until ch+"zzzz..."

        int len = pass.length();
        String buffer = start + "";
        String atk = buffer.repeat(len);
        while (!atk.equals(pass) && !isFound) {
            System.out.println(atk);
            int i;
            for (i = len-1; atk.charAt(i) == 'z'; i--);
            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len-i-1);
            atk = first + next + after;
        }

        if(!isFound) {
            System.out.println("Found: " + atk);
        }

        isFound = true;
    }
}
