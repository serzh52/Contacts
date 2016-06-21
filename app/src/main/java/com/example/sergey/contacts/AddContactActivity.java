package com.example.sergey.contacts;

import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    public void addContact(View view) {

        ContentValues contactValues = new ContentValues();
        EditText contactText = (EditText) findViewById(R.id.contactText);
        String newContact = contactText.getText().toString();
        contactValues.put(RawContacts.ACCOUNT_NAME, newContact);
        contactValues.put(RawContacts.ACCOUNT_TYPE, newContact);
        Uri newUri = getContentResolver().insert(RawContacts.CONTENT_URI, contactValues);
        long rawContactsId = ContentUris.parseId(newUri);
        contactValues.clear();
        contactValues.put(Data.RAW_CONTACT_ID, rawContactsId);
        contactValues.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        contactValues.put(StructuredName.DISPLAY_NAME, newContact);
        getContentResolver().insert(Data.CONTENT_URI, contactValues);
        Toast.makeText(this, newContact + " добавлен в список контактов", Toast.LENGTH_LONG).show();
    }
}
