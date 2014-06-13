<%--
  Created by IntelliJ IDEA.
  User: nburk
  Date: 6/5/14
  Time: 8:28 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'userStory.label', default: 'UserStory')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <g:javascript>
        function checkConditions() {
            if (!document.getElementById("chkaccept").checked) {

                document.getElementById("flag").innerHTML = "Please accept the terms & conditions.";
                return false;
            }

            else {
                return true;
            }
        }

    </g:javascript>

    <title></title>
</head>

<body>

<form action="category" method="post" onSubmit="return checkConditions()">
    <input name="__RequestVerificationToken" type="hidden" value="aQbB4J1SqnKVkP8j_W8VU6AijW_pE8F7e492b1xLriopNEISulTqymNFJe02-cNlW0BnMXAxG8oqHk7x18fo9ej9wW8-ND66unBFScPFSrw1" /><p>
    <strong>Ready to share your story?</strong></p>
    <br />
    <p><strong>Here's how it works</strong></p>
    <p>
        1. Read and accept the Terms and Conditions below<br />
        2. Create your story using our Story Wizard, with optional images or video<br />
    </p>
    <br />
    <p><strong>Get the word out</strong></p>
    <p>
        After you create your story:<br />
        1. Share your story on our site, and your social media sites<br />
        2. Download a free personalized infographic of your story to share<br />
    </p>
    <div style="padding-left: 30px;">
        <p>*OPTION: You will have to option to create a free account, which is necessary if you want to edit or delete you story later.</p>
        <br />

        <div  style="width: 80em;">
            <table>

                    <p>Terms & Conditions</p>
                    <p><a href="http://www.cdc.gov/other/privacy.html">View Privacy Policy</a></p>



                        <textarea name="myTextBox" cols="200" rows="5" style="margin: 0px 0px 10px; width: 795px; height: 100px;">
                           ${TermsAndConditions}
                        </textarea>


                <tr><td colspan="2" style="text-align:center;"><p style="display:inline;"><input type="checkbox" name="checkaccept" id="chkaccept" value="I Accept" />
                    <label for="chkaccept">I Accept!</label> &nbsp;<input type="submit" value="I'm Ready!" id="btnsubmit"/></p> </td></tr>
            </table>
            <p id="flag" style="color:red"></p>
        </div>

    </div>
    <div>

    </div>
</form>

</body>
</html>