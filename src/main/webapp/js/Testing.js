Testing = function(options)
{

    // constructor
    //-------------------------------

    var self = this;

    this.answerUrl = null;
    this.resultsUrl = null;
    this.$questionAnswersTemplate = null;
    this.$questionAnswersContainer = null;
    this.question = null;
    this.secondsCount = null;
    this.counter = null;
    $.extend(this, options);


    this.initialize = function()
    {
        $("input:radio[name=answer]:last").attr('checked', true);
        self.$questionAnswersContainer = $('#questionContainer');
        self.$questionAnswersTemplate = $("#questionAnswers").html();
        self.renderQuestion(jQuery.parseJSON(self.question));
        self.resetTimer();
    }

    this.timer = function()
    {
        self.secondsCount = self.secondsCount - 1;
        if (self.secondsCount < 0)
        {
            clearInterval(self.counter);
            self.answer();
            return;
        }

        $("#secondsContainer").html(self.secondsCount);
    }

    this.resetTimer = function()
    {
        self.secondsCount = 30;
        self.counter = setInterval(self.timer, 1000);
    }

    this.getChosenAnswerId = function()
    {
        return $('input:radio[name=answer]:checked').val()
    };

    this.renderQuestion = function(question)
    {
        var questionAnswersHtml = Mustache.render(self.$questionAnswersTemplate, question);
        self.$questionAnswersContainer.html(questionAnswersHtml);
    };

    this.answer = function()
    {
        var request = $.ajax({
            url: self.answerUrl + ".json",
            type: "POST",
            contentType: "application/json",
            data: self.getChosenAnswerId()
        });
        request.done(function(response) {
            if(!response)
                window.location.href = self.resultsUrl;
            else
            {
                self.renderQuestion(jQuery.parseJSON(response));
                self.resetTimer();
            }

        });
        request.fail(function(message) {
            alert(message);
        });
    };
};
