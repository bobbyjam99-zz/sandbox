import java.util.function.Consumer;

/**
 * Created by bobbyjam99 on 2014/05/24.
 */
public class FluentMailer {

    private FluentMailer() {
    }

    public FluentMailer from(final String address) {
        /*... */;
        return this;
    }

    public FluentMailer to(final String address) {
        /*... */;
        return this;
    }

    public FluentMailer subject(final String line) {
        /*... */;
        return this;
    }

    public FluentMailer body(final String message) {
        /*... */;
        return this;
    }

    public static void send(final Consumer<FluentMailer> block) {
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("sending...");
    }

    //...
    public static void main(final String[] args) {
        FluentMailer.send(mailer ->
                mailer.from("hoge@foo.com")
                        .to("foo@bar.com")
                        .subject("test subject")
                        .body("test body"));
    }
}
