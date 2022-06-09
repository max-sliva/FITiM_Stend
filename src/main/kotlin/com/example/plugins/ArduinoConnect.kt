package com.example.plugins

import io.ktor.server.application.*
import jssc.SerialPort
import jssc.SerialPortList


fun Application.configureArduinoConnect() {
    var serialPort: SerialPort?
    for (port in SerialPortList.getPortNames()) {
        println(port)
        serialPort = SerialPort(port)
        serialPort.openPort()
        serialPort.setParams(9600, 8, 1, 0)
        serialPort.addEventListener{
            if (it.isRXCHAR()) {// если есть данные для приема
                    var str = serialPort.readString()
//убираем лишние символы (типа пробелов, которые могут быть в принятой строке)
                    str = str.trim();
//проверяем принятую строку, и либо ставим, либо убираем галочку в чек-боксе
               //     if (str.contains("recv=1")) check.setSelected(true);
               //     if (str.contains("recv=0")) check.setSelected(false);
                    println(str) //выводим принятую строку
            }
        }
    }
}

