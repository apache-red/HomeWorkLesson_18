package com.redcompany.red.library.controller.command;

import com.redcompany.red.library.data.DataBase;


import java.util.Map;


public interface BasicCommand {

     void performAction(Map<String, Object> userdata, DataBase dataBase);



}
