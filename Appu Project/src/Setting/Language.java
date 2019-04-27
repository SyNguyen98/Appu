package Setting;

public class Language {
    public static void setEnglish() {
        SettingMenu.infoMenu.setText("Change Info");
        SettingMenu.avatarItem.setText("Change Avatar");
        SettingMenu.nameItem.setText("Change Name");
        SettingMenu.guideItem.setText("Guide");
        SettingMenu.infoItem.setText("Information");
        SettingMenu.languageMenu.setText("Language");
    }
    
    public static void setVietnamese() {
        SettingMenu.infoMenu.setText("Thay đổi thông tin");
        SettingMenu.avatarItem.setText("Thay ảnh đại diện");
        SettingMenu.nameItem.setText("Thay đổi tên");
        SettingMenu.guideItem.setText("Hướng dẫn");
        SettingMenu.infoItem.setText("Thông tin");
        SettingMenu.languageMenu.setText("Ngôn ngữ");
    }
}
