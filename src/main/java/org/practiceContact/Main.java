package org.practiceContact;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static     Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String filepath = "E:\\project\\test_file";
        String fileName = "contactList.txt";

        Contact contact = new Contact();

        boolean finish = false;

        while (!finish) {
            System.out.println("번호를 선택하세요. 1.추가 2.조회 3.수정 4.삭제 5.txt 파일로 저장 6.파일내용 조회 7.끝" );
            String select = scan.next();
            switch (select) {
                case "1":
                    contact.insertData(createData());
                    break;
                case "2":
                    contact.readData();
                    break;
                case "3":
                    System.out.println("수정할 이름을 입력하세요.");
                    contact.updateData(scan.next(), inputUpdateData());
                    break;
                case "4":
                    System.out.println("삭제할 이름을 입력하세요.");
                    contact.deldteData(scan.next());
                    break;
                case "5":
                    System.out.println("파일이 저장되었습니다.");
                    FileUtil.createFile(filepath, fileName, contact.getContactDataList());
                    break;
                case "6":
                    System.out.println("파일 내용물입니다.");
                    FileUtil.readFile(filepath, fileName);
                    break;
                case "7" :
                    System.out.println("연락처를 닫습니다.");
                    finish = true;
                    break;
                default:
                    System.out.println("잘못 입력했습니다.");
            }
        }

    }

    // 추가할 연락처 입력
    private static ContactData createData() {
        ContactData contactData = new ContactData();

        System.out.println("이름");
        contactData.setName(scan.next());

        System.out.println("번호");
        contactData.setPhoneNum(scan.next());

        return contactData;
    }

    //수정할 연락처 입력
    private static ContactData inputUpdateData() {
        ContactData contactData = new ContactData();

        System.out.println("이름을 어떻게 바꿀건가요?");
        contactData.setName(scan.next());

        System.out.println("번호를 어떻게 바꿀건가요?");
        contactData.setPhoneNum(scan.next());

        return contactData;
    }
}
