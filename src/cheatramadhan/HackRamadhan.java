package cheatramadhan;

import arc.Events;
import arc.scene.ui.Label;
import arc.scene.ui.TextButton;
import arc.scene.utils.Elem;
import mindustry.*;
import mindustry.game.EventType;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class HackRamadhan extends Mod{

    public HackRamadhan(){
    }

    @Override
    public void init(){
        Events.on(EventType.ClientLoadEvent.class, e -> {
            Vars.ui.settings.addCategory("Hack Ramadhan", t -> {
                t.pref(new TextSeparator("HACK RAMADHAN 2025"));
                t.checkPref("Fast Time", false);
                t.checkPref("Auto Buka", false);
                t.checkPref("Auto Sahur", false);
                t.checkPref("Hack Pahala", false);
                t.checkPref("Anti Lapar", false);
                t.checkPref("Auto Khatam", false);
                t.checkPref("Hack Amal", false);
                t.checkPref("Anti Nafsu", false);
                t.textPref("", "Jane Doe");
                t.textPref("", "Washington DC");
                t.pref(new ThisButtonSetting());
            });
        });
    }

    static class TextSeparator extends SettingsMenuDialog.SettingsTable.Setting {
        String text;
        public TextSeparator(String text){
            super("");
            this.text = text;
        }
        @Override
        public void add(SettingsMenuDialog.SettingsTable table){
            Label b = new Label(text);
            b.setText(text);
            b.getStyle().background = Tex.underline;
            b.setAlignment(1);
            table.add(b).growX();
            table.row();
        }
    }
    static class ThisButtonSetting extends SettingsMenuDialog.SettingsTable.Setting {
        public ThisButtonSetting() {
            super("");
        }
        @Override
        public void add(SettingsMenuDialog.SettingsTable settingsTable) {
            TextButton HackBtn = Elem.newButton(null, () -> Vars.ui.showInfo("Selamat Anda telah berhasil menghack ramadhan!"));
            TextButton CreatedBtn = Elem.newButton(null, () -> Vars.ui.showInfo("Created by WilloIzCitron"));
            TextButton TrialBtn = Elem.newButton(null, () -> Vars.ui.showInfo("COMING SOON!"));
            HackBtn.label(() -> "GO HACK").center().growX();
            CreatedBtn.label(() -> "CREATED").center().growX();
            TrialBtn.label(() -> "TRIAL").center().growX();
            addDesc(settingsTable.add(CreatedBtn).center().get());
            settingsTable.row();
            addDesc(settingsTable.add(HackBtn).center().get());
            settingsTable.row();
            addDesc(settingsTable.add(TrialBtn).center().get());
            settingsTable.row();
        }
    }
}