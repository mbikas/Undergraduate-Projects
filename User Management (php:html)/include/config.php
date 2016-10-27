<?php

        $db_host = 'localhost';
        $db_user = 'root';
        $db_password = 'triadpass';
        $db_name = 'ccna';

        function connect_db()
        {
                global $db_host, $db_user, $db_password, $db_name;
                
                $link = mysql_pconnect($db_host, $db_user, $db_password);
                if (!$link) {
                    die('Not connected : ' . mysql_error());
                }

                $db_selected = mysql_select_db($db_name, $link);
                if (!$db_selected) {
                    die ('Error  : ' . mysql_error());}

                return $link;
        }
?>
