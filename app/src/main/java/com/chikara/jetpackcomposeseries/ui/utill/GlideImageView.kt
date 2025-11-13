package com.example.app.ui.common

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun GlideImageView(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
    cornerRadius: Dp = 8.dp,
    contentScale: ContentScale = ContentScale.Crop,
    shimmerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
) {
    val context = LocalContext.current
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }

    val shimmer: Shimmer = rememberShimmer(ShimmerBounds.View)

    // Load image via Glide
    LaunchedEffect(imageUrl) {
        if (imageUrl.isNullOrEmpty()) {
            isError = true
            isLoading = false
            return@LaunchedEffect
        }

        Glide.with(context)
            .asBitmap()
            .load(imageUrl)
            .transform(CenterCrop(), RoundedCorners(cornerRadius.value.toInt()))
            .listener(object : RequestListener<android.graphics.Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>,
                    isFirstResource: Boolean
                ): Boolean {
                    isError = true
                    isLoading = false
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap,
                    model: Any,
                    target: Target<Bitmap>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    isError = false
                    isLoading = false
                    return false
                }
            })
            .into(object : CustomTarget<android.graphics.Bitmap>() {
                override fun onResourceReady(
                    resource: android.graphics.Bitmap,
                    transition: Transition<in android.graphics.Bitmap>?
                ) {
                    imageBitmap = resource.asImageBitmap()
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    imageBitmap = null
                }
            })
    }

    // UI
    Surface(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(cornerRadius))
            .background(backgroundColor),
        color = Color.Transparent
    ) {
        when {
            isLoading -> {
                // Shimmer Placeholder
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(cornerRadius))
                        .shimmer(shimmer)
                        .background(shimmerColor)
                )
            }

            isError -> {
                // Error Placeholder
                Box(
                    modifier = Modifier
                        .background(Color.Gray.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    androidx.compose.material3.Text(
                        text = "⚠️",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            imageBitmap != null -> {
                Image(
                    painter = BitmapPainter(imageBitmap!!),
                    contentDescription = "Loaded image",
                    contentScale = contentScale,
//                    modifier = Modifier.matchParentSize()
                )
            }
        }
    }
}
