<#import "spring.ftl" as spring />
<@spring.bind "recherche" />
<!DOCTYPE html>
<html>
    <body>
        <form method="POST" action="<@spring.url '/rechercher' />">
            <div style="color:red;">
                <@spring.bind "recherche.code" />
                <@spring.showErrors ', ' ''/>
            </div>
        <@spring.formInput 'recherche.code', 'size=20 placeholder="Saisir un code avantage"' />
            <button type="submit">Rechercher</button>
        </form>
        <#if recherche.autre ?? >
        Vous venez de POST ${recherche.code} et flash info: ${recherche.autre}
        </#if>
    </body>
</html>
