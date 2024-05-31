package edu.upc.dsa.martianslog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.upc.dsa.martianslog.models.Topic;
import edu.upc.dsa.martianslog.service.ApiService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Minimo2Activity extends AppCompatActivity {

    private EditText questionText;
    private EditText answerText;
    private Button buttonSendQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimo2);

        questionText = findViewById(R.id.questionText);
        answerText = findViewById(R.id.answerText);
        buttonSendQuestion = findViewById(R.id.buttonSendQuestion);

        buttonSendQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = questionText.getText().toString();
                if (!question.isEmpty()) {
                    sendQuestionToServer(question);
                } else {
                    Toast.makeText(Minimo2Activity.this, "Por favor, ingrese una pregunta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendQuestionToServer(String question) {
        String currentDate = "2024-06-01"; // Obtén la fecha actual de alguna manera
        String questionTitle = "Ejemplo de pregunta"; // Obtén el título de la pregunta
        String questionMessage = "Mensaje de la pregunta"; // Obtén el mensaje de la pregunta
        String questionSender = "Usuario123"; // Obtén el remitente de la pregunta

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/dsaApp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Topic questionData = new Topic(currentDate, questionTitle, questionMessage, questionSender);
        Call<ResponseBody> call = apiService.sendQuestion(questionData);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String responseBody = response.body().string();
                        answerText.setText(responseBody);
                        Toast.makeText(Minimo2Activity.this, "Pregunta enviada con éxito", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(Minimo2Activity.this, "Error al procesar la respuesta", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Minimo2Activity.this, "Error al enviar la pregunta", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(Minimo2Activity.this, "Fallo de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }}

