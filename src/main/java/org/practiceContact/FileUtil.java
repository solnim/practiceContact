package org.practiceContact;

import java.io.*;
import java.util.List;

public class FileUtil {
    public static void createFile(String filepath, String fileName, List<ContactData> contactList) {
        File path = new File(filepath);

        if(!path.exists()){
            path.mkdirs();
        }
        //파일 생성
        File file = new File(filepath, fileName);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            for(int i = 0; i<contactList.size(); i++){
                String writeData = contactList.get(i).getName() + ", " + contactList.get(i).getPhoneNum()+"\n";
                bos.write(writeData.getBytes());
            }
            bos.close();
            fos.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile(String filepath, String fileName) throws IOException {

        BufferedReader br = new BufferedReader(
                new FileReader(filepath+"\\"+fileName)
        );
        String fileContent;

        while ((fileContent = br.readLine()) != null){
            System.out.println(fileContent);
        }
        br.close();

    }
}
