package org.practiceContact;

import java.util.ArrayList;
import java.util.List;

//리스트에 입력받은 데이터를 저장
// 리스트 조회, 수정, 삭제 기능
public class Contact {
    private final List<ContactData> contactDataList = new ArrayList<>();

    void insertData(ContactData contactData){
        contactDataList.add(contactData);
    }

    void readData(){
        if(contactDataList.isEmpty()){
            System.out.println("연락처 목록이 비어있습니다.");
        }else {
            for(int i = 0; i<contactDataList.size(); i++){
                System.out.println(contactDataList.get(i).getName() + ", " + contactDataList.get(i).getPhoneNum());
            }
        }
    }

    public void updateData(String originName, ContactData updateList) {
        int cnt = 0;
        if(contactDataList.isEmpty()){
            System.out.println("연락처 목록이 비어있습니다.");
        }else {
            for (int i = 0; i < contactDataList.size(); i++) {
                if (contactDataList.get(i).getName().equals(originName)) {
                    contactDataList.remove(i);
                    contactDataList.add(i, updateList);
                    cnt++;
                }
            }
        }
        if(cnt == 0){
            System.out.println("그런 이름은 없어서 수정하지 못했습니다.");
        }
    }

    public void deldteData(String deletedName) {
        int cnt = 0;
        if(contactDataList.isEmpty()){
            System.out.println("연락처 목록이 비어있습니다.");
        }else {
            for (int i = 0; i < contactDataList.size(); i++) {
                if (contactDataList.get(i).getName().equals(deletedName)) {
                    contactDataList.remove(i);
                }
                cnt++;
            }
        }
        if(cnt == 0){
            System.out.println("그런 이름은 없습니다.");
        }
    }

    public List<ContactData> getContactDataList() {
        return contactDataList;
    }

}
