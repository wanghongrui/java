public class MultiThreadDown {
    public static void main(String[] args) {
        final InetAddressTest iA = new InetAddressTest("http://d.lanrentuku.com/down/png/1709/mahjong-icons/pin6.png",
                "ios.png", 4);
        try {
            iA.download();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            while (iA.getCompleteRate() < 1) {
                System.out.println("已完成：" + iA.getCompleteRate());
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
        }).start();
    }
}
