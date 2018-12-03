package com.redcompany.red.library.controller.command;

import com.redcompany.red.library.data.collection.LibraryCommand;

import java.util.Map;


public interface BasicCommand {

    public void performAction(Map<String, Object> userdata, LibraryCommand libraryCommand);



}
