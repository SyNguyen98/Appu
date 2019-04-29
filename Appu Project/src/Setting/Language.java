package Setting;

import MainFrame.InputPanel;
import OtherFrame.InformationFrame;

public class Language {
    public static void setEnglish() {
        SettingMenu.infoMenu.setText("Change Info");
        SettingMenu.avatarItem.setText("Change Avatar");
        SettingMenu.nameItem.setText("Change Name");
        SettingMenu.guideItem.setText("Guide");
        SettingMenu.infoItem.setText("Information");
        SettingMenu.languageMenu.setText("Change Language");
        InputPanel.inputField.setText("Say something ...");
        InformationFrame.versionLabel.setText("Version 2.1.7");
        InformationFrame.infoLabel.setText("<html>   i.Sekai is a multimedia virtual assistant developed by a mystery anomyous team, written in Java."
                            + " Software's name has inspiration from the meaning 'The World' in Japanese, compline with 'i' to create"
                            + " a new convinient and modern world for almost users on Windows OS. It can make not only an impression in the way using computer"
                            + " but also change the experience when you surfing Internet. Let's try it once, you will lust to use it again!"
                            + "</html>");
        OtherFrame.InformationFrame.infoLabel1.setText("<html> Lastest updated on 29th April 2019. </html>");
    }
    
    public static void setVietnamese() {
        SettingMenu.infoMenu.setText("Thay đổi thông tin");
        SettingMenu.avatarItem.setText("Thay ảnh đại diện");
        SettingMenu.nameItem.setText("Thay đổi tên");
        SettingMenu.guideItem.setText("Hướng dẫn");
        SettingMenu.infoItem.setText("Thông tin");
        SettingMenu.languageMenu.setText("Thay đổi ngôn ngữ");
        InputPanel.inputField.setText("Hãy thử gõ gì đó ...");
        InformationFrame.versionLabel.setText("Phiên bản 2.1.7");
        InformationFrame.infoLabel.setText("<html>    i.Sekai là trợ lý ảo đa chức năng được phát triển bởi một nhóm bí ẩn, viết bằng ngôn ngữ Java."
                            + " Tên của phần mềm được lấy cảm hứng từ từ 'Thế giới' trong tiếng Nhật, kết hợp với 'i' tạo nên một 'Thế giới ảo' hiện đại,"
                            + " tiện dụng cho người dùng trên hệ điều hành Windows. Nó không chỉ thay đổi ấn tượng cách sử dụng máy tính thông thường mà còn"
                            + " mang đến trải nghiệm mới lạ khi bạn sử dụng đa phương tiện thông qua Internet. Hãy thử sử dụng i.Sekai một lần, rồi bạn sẽ"
                            + " muốn trải nghiệm nó thêm nhiều lần nữa!"
                            + "</html>");
        OtherFrame.InformationFrame.infoLabel1.setText("<html>Cập nhật gần nhất: 29 tháng 4, 2019. </html>");
    }
}
