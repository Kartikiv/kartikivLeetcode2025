class MyThread extends Thread {
    int[] row;

    public MyThread(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        // flip 
        int i = 0;
        int j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
        // invert 
        for (int k = 0; k < row.length; k++) {
            row[k] = row[k] ^ 1;
        }
    }

}

class Solution {
    public int[][] flipAndInvertImage(int[][] image){
        MyThread[] threads = new MyThread[image.length];

        for (int i = 0; i < image.length; i++) {
            threads[i] = new MyThread(image[i]);
            threads[i].start();
        }

        for (int i = 0; i < image.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        return image;
    }

}