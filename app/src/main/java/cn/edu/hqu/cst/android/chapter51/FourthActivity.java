package cn.edu.hqu.cst.android.chapter51;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FourthActivity extends Activity {

    final private int PICK_CONTACT=0;
    Button btnGetContact;
    EditText Edttel,Edtname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        btnGetContact=findViewById(R.id.btn_GetContact);
        Edttel=findViewById(R.id.ContactTel);
        Edtname=findViewById(R.id.ContactName);
        btnGetContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("vnd.android.cursor.item/phone");
                startActivityForResult(intent,PICK_CONTACT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case PICK_CONTACT:
                if(resultCode==Activity.RESULT_OK){
                    Uri contactData=data.getData();
                    CursorLoader cursorLoader=new CursorLoader(this,contactData,null,null,null,null);
                    Cursor cursor=cursorLoader.loadInBackground();
                    if(cursor.moveToFirst()){
                        String contactId=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name=cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumber="此联系人暂未输入电话号码";
                        Cursor phones=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+contactId,null,null);
                        if(phones.moveToFirst()){
                            phoneNumber=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phones.close();
                        Edttel.setText(phoneNumber);
                        Edtname.setText(name);

                    }
                    cursor.close();
                }
                break;
        }
    }
}
