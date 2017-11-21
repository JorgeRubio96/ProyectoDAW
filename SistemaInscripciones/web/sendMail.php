<?php

$sendTo= $_POST['postsendTo'];
$message= $_POST['postmessage'];
$subject= "Informacion Inscripciones";

$encoding = "utf-8";

// Preferences for Subject field
$subject_preferences = array(
    "input-charset" => $encoding,
    "output-charset" => $encoding,
    "line-length" => 76,
    "line-break-chars" => "\r\n"
);

// Mail header
$header = "Content-type: text/html; charset=".$encoding." \r\n";
$header .= "From: Sistema Inscripciones <inscripcionesdaw2017@gmail.com> \r\n";
$header .= "MIME-Version: 1.0 \r\n";
$header .= "Content-Transfer-Encoding: 8bit \r\n";
$header .= "Date: ".date("r (T)")." \r\n";
$header .= iconv_mime_encode("Subject", $subject, $subject_preferences);

// Send mail
$didSend= mail($sendTo, $subject, $message, $header);
?>
