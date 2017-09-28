import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maven on 2017/6/6.
 */
public class data {


    public static double IDW(double[] num, double[] lbs, double[] lb) {
        double Pi = Math.PI;
        double idw ;
        double A, Bnum, C, D, B1, B2, L1, L2, L, B;
        A = num[0];
        Bnum = num[1];
        C = num[2];
        D = num[3];

        B1 = lbs[0];
        B2 = lbs[1];
        L1 = lbs[2];
        L2 = lbs[3];

        L = lb[0];
        B = lb[1];

        double Cap, Dap,
               Cbp, Dbp,
               Ccp, Dcp,
               Cdp, Ddp;
        double _AP,
               _BP,
               _CP,
               _DP;
        Cap = Math.sin(B2) * Math.sin(B) + Math.cos(B2) * Math.cos(B) * Math.cos(L1 - L);

        Dap = 6371.004 * Math.acos(Cap) * Pi / 180;
        Cbp = Math.sin(B2) * Math.sin(B) + Math.cos(B2) * Math.cos(B) * Math.cos(L2 - L);
        Dbp = 6371.004 * Math.acos(Cbp) * Pi / 180;
        Ccp = Math.sin(B1) * Math.sin(B) + Math.cos(B1) * Math.cos(B) * Math.cos(L1 - L);
        Dcp = 6371.004 * Math.acos(Ccp) * Pi / 180;
        Cdp = Math.sin(B1) * Math.sin(B) + Math.cos(B1) * Math.cos(B) * Math.cos(L2 - L);
        Ddp = 6371.004 * Math.acos(Cdp) * Pi / 180;

        _AP = (1 / Dap) / (1 / Dap + 1 / Dbp + 1 / Dcp + 1 / Ddp);
        _BP = (1 / Dbp) / (1 / Dap + 1 / Dbp + 1 / Dcp + 1 / Ddp);
        _CP = (1 / Dcp) / (1 / Dap + 1 / Dbp + 1 / Dcp + 1 / Ddp);
        _DP = (1 / Ddp) / (1 / Dap + 1 / Dbp + 1 / Dcp + 1 / Ddp);
        idw = _AP * A + _BP * Bnum + _CP * C + _DP * D;
        return idw;

    }

    public static Map<String, Double> lb(double l, double b) {
        Map<String, Double> map = new HashMap();
        double B = Math.floor(b);
        double p, q, m, n;
        double j, k;
        double B1, B2;
        System.out.println(B);
        if (B % 2 != 0) {
            System.out.println("奇数");
            B1 = B - 1;
            B2 = B + 1;
        } else {
            System.out.println("偶数");
            B1 = B;
            B2 = B + 2;
        }
        m = (90 - B2) / 2 + 1;
        n = (90 - B1) / 2 + 1;
        p = Math.floor(l / 2.5) + 1;
        q = Math.floor(l / 2.5) + 2;
        map.put("B1", m);
        map.put("B2", n);
        map.put("L1", p);
        map.put("L2", q);

        System.out.println("mnpq-------->" + m + "," + n + "," + p + "," + q);
        return map;

    }

    public static double average(double[] num) {
        double sum = 0;
        int len = num.length;
        for (double n : num) {
            sum += n;
        }
        return sum / len;

    }

    public static double nearest(double[] num, double[] lbs, double[] lb) {
        double bCenter = (lbs[0] + lbs[1]) / 2;
        double lCenter = (lbs[2] + lbs[3]) / 2;
        double l = lb[0] - lCenter, b = lb[1] - bCenter;
        double near = 0;
        if (l >= 0) {
            if (b >= 0) {
                near = num[1];
            } else {
                near = num[3];
            }
        } else {
            if (b >= 0) {
                near = num[0];
            } else {
                near = num[2];
            }
        }
        return near;
    }

    public static double douTim(double[] num, double[] lbs, double[] lb) {
        double A, Bnum, C, D, B1, B2, L1, L2, L, B;
        A = num[0];
        Bnum = num[1];
        C = num[2];
        D = num[3];

        B1 = lbs[0];
        B2 = lbs[1];
        L1 = lbs[2];
        L2 = lbs[3];

        L = lb[0];
        B = lb[1];

        double doutim = 0;
        doutim = C / 5 * (L2 - L) * (B2 - B) + D / 5 * (L - L1) * (B2 - B) + A / 5 * (L2 - L) * (B - B1) + Bnum / 5 * (L - L1) * (B - B1);
        return doutim;
    }

    public static void main(String[] args)
            throws IOException {
      	/*
		*填写文件夹的名称，输出文件夹的名称，站点坐标
		*
		*/
		String originalDocument = "yue";//处理的文件名
		String generateDocument = "2out.txt";//生成的文件名
		double bz = 36.06, lz = 120.33;//站点坐标
        Map<String, Double> map = lb(lz, bz);

        int m, n, p, q;
        double B1, B2, L1, L2;

        double[] lbs = new double[4];
        double[] lbb = new double[2];

        lbb[0] = lz;
        lbb[1] = bz;
        double M = map.get("B1");
        double N = map.get("B2");
        //小精度
        p = (int) ((double) map.get("L1"));
        //大精度
        q = (int) ((double) map.get("L2"));


        double tttt = Math.floor(bz);
        if (tttt % 2 != 0) {
            System.out.println("奇数");
            B1 = tttt - 1;
            B2 = tttt + 1;
        } else {
            System.out.println("偶数");
            B1 = tttt;
            B2 = tttt + 2;
        }
        L1 = (p - 1) * 2.5;
        L2 = (q - 1) * 2.5;
  

        lbs[0] = B1;
        lbs[1] = B2;
        lbs[2] = L1;
        lbs[3] = L2;



        //小维度
        m = (int) ((M -1)* (360 / 2.5 + 1));
        //大维度
        n = (int) ((N-1) * (360 / 2.5 + 1));

        int a, b, c, d;
        a = m + p;//A
        b = m + q;//B
        c = n + p;//C
        d = n + q;//D


        FileWriter fw = new FileWriter("./"+generateDocument);
        BufferedWriter bufw = new BufferedWriter(fw);
        File fs = new File("./"+originalDocument);
        File[] temfs = fs.listFiles();
        int i = 0;
        for (File f : temfs) {
            String[] names = f.getName().split(".h");

            FileReader filereader = new FileReader(f);
            BufferedReader buff = new BufferedReader(filereader);

            String valueString = null;
            int len = 0;
            double A = 0, B = 0, C = 0, D = 0;
            double[] abcd = new double[4];
            int j = 0;
            while ((valueString = buff.readLine()) != null) {
                String[] strs = valueString.split(" ");

                if (1 <= a - len && a - len < 12) {
                    A = Double.valueOf(strs[a - len ]);


                }
                if (1 <= b - len && b - len < 12) {
                    B = Double.valueOf(strs[b - len]);
                }
                if (1 <= c - len && c - len < 12) {
                    C = Double.valueOf(strs[c - len ]);
                }
                if (1 <= d - len && d - len < 12) {
                    D = Double.valueOf(strs[d - len ]);
                }
                if (j == 0) {
                    j += 1;
                } else {
                    len += (strs.length - 1);
                }
            }
            abcd[0] = A;
            abcd[1] = B;
            abcd[2] = C;
            abcd[3] = D;
            System.out.println(f.getName() + "A-->" + A);
            System.out.println(f.getName() + "B-->" + B);
            System.out.println(f.getName() + "C-->" + C);
            System.out.println(f.getName() + "D-->" + D);

            double aver = average(abcd);
            double nearest = nearest(abcd, lbs, lbb);
            double doutim = douTim(abcd, lbs, lbb);
            double idw = IDW(abcd, lbs, lbb);
            if (names[1].equalsIgnoreCase("00")) {
                String[] ss = names[0].split("t12");
                bufw.write(ss[1]);
                bufw.write(" ");
            } else {
                bufw.write("");
                bufw.write(" ");
            }
            bufw.write(f.getName());
            bufw.write(" ");
            bufw.write(Double.toString(aver));
            bufw.write(" ");

            bufw.write(Double.toString(nearest));
            bufw.write(" ");

            bufw.write(Double.toString(doutim));
            bufw.write(" ");

            bufw.write(Double.toString(idw));
            bufw.newLine();
            //System.out.println(f.getName());
        }

        bufw.flush();
        bufw.close();
        fw.close();


    }

}
