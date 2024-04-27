package com.eslamaped.jetnote.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier=Modifier,
    text:String,
    label:String,
    maxLine:Int=1,
    onTextChange:(String) -> Unit,
    onImeAction: () -> Unit ={}
    
){
    val keyboardController=LocalSoftwareKeyboardController.current
//    TextField(value = text, onValueChange = onTextChange, maxLines = maxLine,modifier=modifier,
//        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),KeyboardActions=KeyboardActions(onDone = {onImeAction()
//        keyboardController?.hide()}))
//    TextField(value = text, onValueChange = onTextChange,maxLines=maxLine, label = {},
//        KeyboardOptions=KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
//        KeyboardActions=KeyboardActions(onDone = {onImeAction()
//            keyboardController?.hide()
//        })
//        ,modifier=modifier
//        )

    TextField(value = text, onValueChange = onTextChange,label={ Text(text = label)},
        maxLines = maxLine, keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboardController?.hide()
            }
        )
        , modifier = modifier)

}

@Composable
fun NoteBotton(
    modifier: Modifier=Modifier,
    text: String,
    onclick: () -> Unit,
    enabled: Boolean=true
){
Button(onClick =  onclick, shape = CircleShape, enabled = enabled, modifier = modifier) {
Text(text)
}
}