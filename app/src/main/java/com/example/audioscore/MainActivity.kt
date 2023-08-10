package com.example.audioscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createPathsToSaveFiles()

        /*// "context" must be an Activity, Service or Application object from your app.
        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(context));
        }*/
        setContentView(R.layout.activity_main)
    }

    private fun createPathsToSaveFiles() {
        try {
            val basePath: File = getExternalFilesDir(null) ?: filesDir
            val folderName = "AudioScore"
            val folder = File(basePath, folderName)
            if (!folder.exists()) {
                folder.mkdirs()
                val subfolderNames = listOf("Recordings", "MIDI files", "MusicXML files", "PDFs")

                for (subfolderName in subfolderNames) {
                    val subfolder = File(folder, subfolderName)
                    if (!subfolder.exists()) {
                        subfolder.mkdirs()
                    }
                }
            }
        } catch (e: Exception) {
            throw Exception("Error while creating root folders: " + e.message)
        }
    }

    fun loadSong() {

        val downloadsPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val filename = "River-flows-in-you.wav"
        val audiofile = File(downloadsPath, filename)

        // Verificar si el archivo existe antes de intentar leerlo
        if (audiofile.exists()) {
            // Aquí puedes implementar la lógica para leer el archivo de audio
            // Por ejemplo, puedes utilizar librerías como MediaPlayer para reproducir el audio
        } else {
            // El archivo no existe en la carpeta de descargas
        }
    }

}