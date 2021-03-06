package com.benny.app.sample.network.service.caishuo;

import com.google.gson.JsonElement;
import com.benny.app.sample.model.Error;

/**
 * Created by benny on 9/5/15.
 */
public class CaishuoEnveloped {
    public int status;
    public JsonElement data;
    public Error error;

    @Override
    public String toString() {
        return "Status: " + status + " data: " + data.toString();
    }

    public boolean isSuccess(){
        return status == 1;
    }
}
