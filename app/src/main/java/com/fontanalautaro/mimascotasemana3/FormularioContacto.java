package com.fontanalautaro.mimascotasemana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormularioContacto extends AppCompatActivity {

    EditText etNombreContacto,etMailContacto,etMensajeContacto;
    Button btnEnviarContacto;
    String sEmail,sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);

        //Incluir mi action bar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombreContacto = (EditText) findViewById(R.id.etNombreContacto);
        etMailContacto = (EditText) findViewById(R.id.etMailContacto);
        etMensajeContacto = (EditText) findViewById(R.id.etMensajeContacto);
        btnEnviarContacto = (Button) findViewById(R.id.btnEnviarContacto);

        //Sender email credential
        sEmail = "your@email.com";
        sPassword = "YourPersonalPassword";


        btnEnviarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inicializar propiedades
                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.starttls.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");

                //Inicializar sesion
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail,sPassword);
                    }
                });


                try {
                    //Inicializar contenido de mail
                    Message message = new MimeMessage(session);
                    //Remitente
                    message.setFrom(new InternetAddress(sEmail.trim()));
                    //Destinatario
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(sEmail));
                    //Asunto
                    message.setSubject(etMailContacto.getText().toString().trim());
                    //Mensaje
                    message.setText(etMensajeContacto.getText().toString().trim());

                    //Enviar mail
                    new SendMail().execute(message);

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });


    }


    private class SendMail extends AsyncTask<Message,String,String> {
        //Inicializar progress dialog
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Crear y mostrar el progress dialog
            progressDialog = ProgressDialog.show(FormularioContacto.this,
                    "Por favor espere", "Enviando mail", true,false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                //Cuando es exitoso
                Transport.send(messages[0]);
                return "Finalizado";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Desaparecer progress dialog
            progressDialog.dismiss();
            if (s.equals("Finalizado")){
                //Cuando resulta exitoso

                //Inicializar alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(FormularioContacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Finalizado</font>"));
                builder.setMessage("Mail enviado exitosamente");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        //Vaciar todos los edit text
                        etMailContacto.setText("");
                        etMensajeContacto.setText("");
                        etNombreContacto.setText("");
                    }
                });

                //Mostrar alert dialog
                builder.show();
            }else{
                //Cuando ocurre un error
                Toast.makeText(getApplicationContext(),
                        "Algo ocurrio mal",Toast.LENGTH_SHORT).show();
            }

        }
    }
}