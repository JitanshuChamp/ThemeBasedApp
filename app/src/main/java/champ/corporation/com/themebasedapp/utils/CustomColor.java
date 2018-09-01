package champ.corporation.com.themebasedapp.utils;

import champ.corporation.com.themebasedapp.R;

public class CustomColor {
    public void setColorTheme(int n){

        int i = n;

        switch (i){

            case 1:
                Constant.theme = R.style.AppTheme_red;
                break;
            case 2:
                Constant.theme = R.style.AppTheme_pink;
                break;
            case 3:
                Constant.theme = R.style.AppTheme_darpink;
                break;
            default:
                Constant.theme = R.style.AppTheme;
                break;
        }
    }
}
