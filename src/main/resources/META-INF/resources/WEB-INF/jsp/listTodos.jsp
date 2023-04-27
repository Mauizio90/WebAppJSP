<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1> I Tuoi ToDos:</h1>
            <table class="table">
                <thead>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>fatto?</th>
                    <th></th>
                </thead>
                <tbody>
                <c:forEach items="${todos}" var ="todo">
                           <tr>
                               <td>${todo.description}</td>
                               <td>${todo.targetDate}</td>
                               <td>${todo.done}</td>
                               <td><a href="delete-todos?id=${todo.id}" class="btn btn-warning">Elimina</a></td>
                               <td><a href="update-todos?id=${todo.id}" class="btn btn-success">Aggiorna</a></td>
                           </tr>

                </c:forEach>          
                </tbody>
            </table>
            <a href="add-todos" class="btn btn-success"> Aggiungi un ToDos</a>
        </div>
        <%@ include file="common/footer.jspf" %>
