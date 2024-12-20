package com.example.realidadaumentada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.realidadaumentada.ui.Products
import com.example.realidadaumentada.ui.theme.RealidadAumentadaTheme
import org.rajawali3d.view.ISurface
import org.rajawali3d.view.SurfaceView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealidadAumentadaTheme {
                RendererScreen()
            }
        }
    }
}


@Composable
fun RendererScreen() {
//    AndroidView(
//        factory = { context ->
//            val surface = SurfaceView(context).apply {
//                setFrameRate(60.0)
//                renderMode = ISurface.RENDERMODE_WHEN_DIRTY
//            }
//            val renderer = BasicRenderer(context)
//            surface.setSurfaceRenderer(renderer)
//
//            surface
//        },
//        modifier = Modifier.fillMaxSize()
//    )
    Products()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RealidadAumentadaTheme {
        RendererScreen()
    }
}