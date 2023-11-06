import java.io.*;
// Đầu vào chuẩn (Standard Input), Đầu ra chuẩn (Standard Output), Lỗi chuẩn (Standard Error)
public class ReadConsole {
   public static void main(String args[]) throws IOException
   {
      InputStreamReader cin = null;

      try {
         cin = new InputStreamReader(System.in);
         System.out.println("Nhap cac ky tu, 'q' de thoat.");
         char c;
         do {
            c = (char) cin.read();
            System.out.print(c);
         } while(c != 'q');
      }finally {
         if (cin != null) {
            cin.close();
         }
      }
   }
}