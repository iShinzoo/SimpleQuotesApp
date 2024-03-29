package com.example.simplequotesapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplequotesapp.QuoteViewModel
import com.example.simplequotesapp.data.model.Quotes


@Composable
fun QuoteScreen(
    viewModel: QuoteViewModel
){
    val quoteState = viewModel.quote.observeAsState()

    Surface(color = MaterialTheme.colorScheme.background) {
        Column {
            if (quoteState.value != null) {
                QuoteContent(quoteState.value!!)
            } else {
                // Loading indicator or error message
            }
        }
    }
    
}

@Composable
fun QuoteContent(quote: Quotes) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.padding(top = 80.dp, start = 12.dp, end = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Quote: ${quote.content}",
                fontSize = 24.sp)
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Quote: ${quote.author}",
                fontSize = 24.sp)
        }
    }
}

@Preview
@Composable
fun PreviewQuoteContent() {
    val sampleQuote = Quotes("This is a sample quote", "Sample Author")
    QuoteContent(quote = sampleQuote)
}