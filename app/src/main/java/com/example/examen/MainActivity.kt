package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.examen.ui.theme.ExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenTheme {
                Inicio()
                Conversacion(Mensajes.conversationSample)
            }
        }
    }
}

data class Message(val persona: String, val mensajes: String)

@Composable
fun Inicio(){
    Column (modifier = Modifier.fillMaxSize()){
        Text(text = "Alumno:Jordy")
        Text(text = "Soy un alumno")
    }



}

@Composable
fun MensajeCon(msg : Message){
    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(painter = painterResource(id = R.drawable.profesor),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Column {
            Text(text = msg.persona,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall)
            Surface (
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ){
                Text(text = msg.mensajes,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium)
            }

        }

    }
}


@Composable
fun Conversacion(Mensajes: List<Message>){
    LazyColumn {
        items(Mensajes){mensajes ->
            MensajeCon(mensajes)
        }

    }
}
