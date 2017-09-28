public class MultiThreadDown {
    public static void main(String[] args) {
        final InetAddressTest iA = new InetAddressTest("http://www.crazyit.org/" + "attachments/month_1403/1403202355fff6cc9a4fbf6f14a.png",
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
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }).start();
    }
}
